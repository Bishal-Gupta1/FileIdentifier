package DatabaseHandler;

import org.jsoup.HttpStatusException;
import ResourcesScrapper.ResFileInfo;
import ResourcesScrapper.ResOnlineConvert;
import ResourcesScrapper.ResWebopedia;

public class CreateDatabase {
	static DatabaseCon con;

	/**
	 * Extensions are first fetched from WeboPedia.com and its related details are
	 * fetched from FileInfo.com and inserted into database
	 */

	public static void webopediaIntoDB() throws Exception {
		System.out.println("Fetching Extensions from webopedia.com\n...");
		new ResWebopedia().fetchReosurces();

		System.out.println("Fetching Extension's  details from FileInfo.com\n...");
		for (Files file : ResWebopedia.detailsOfExtension) {
			try {
				ResFileInfo fileInfo = new ResFileInfo(file.getExtension());
				file.setDescription(fileInfo.getDescription());
				file.setAuthor(fileInfo.getAuthor());
				file.setCategory(fileInfo.getCategory());
			} catch (HttpStatusException e) {
				System.out.println(e);
			}
		}

		System.out.println("Connecting with DataBase...\n");

		DatabaseCon.session.beginTransaction();
		System.out.println("Inserting object into Database...\n");

		int batchSize = 25;
		int count = 1;
		try {
			for (Files file : ResWebopedia.detailsOfExtension) {
				if (DatabaseCon.session.get(Files.class, file.getExtension()) != null)
					continue;
				if (count == batchSize) {
					DatabaseCon.session.getTransaction().commit();
					System.out.println("Batch Inserted.");
					DatabaseCon.startSession();
					DatabaseCon.session.beginTransaction();
					count = 1;
				}
				DatabaseCon.session.save(file);
				++count;
			}
			System.out.println(".\n.\n.\nInsertion Completed.");
		} catch (Exception e) {
			if (DatabaseCon.session.getTransaction().isActive()) {
				DatabaseCon.session.getTransaction().rollback();
				System.out.println(".\n.\n.\nPartially Inserted");
			}
			System.out.println(e);
		}
	}

	public static void onlineConvertIntoDB() throws Exception {
		new ResOnlineConvert().fetchReosurces();
		System.out.println("Starting Connection...\n");

		DatabaseCon.session.beginTransaction();
		System.out.println("Inserting...\n");

		for (Files file : ResOnlineConvert.detailsOfExtension)
			DatabaseCon.session.save(file);

		DatabaseCon.session.getTransaction().commit();
		System.out.println("Insertion Completed.");

	}

	public static void main(String[] args) {
		new DatabaseCon();
		try {
			DatabaseCon.startSession();
			/**
			 * adding available list of extensions only from webopedia.com around 3100
			 * Extensions are fetched from webopedio.com
			 **/
			onlineConvertIntoDB();

			/**
			 * adding list of extension and its available details : CATEGORY , APPLICATION,
			 * AND AUTHOR from online-convert.com
			 **/
			webopediaIntoDB();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseCon.closeSessionFactory();
			System.gc();
		}

	}

}
