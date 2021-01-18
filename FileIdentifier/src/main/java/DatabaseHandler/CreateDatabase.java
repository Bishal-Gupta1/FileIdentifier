package DatabaseHandler;

import ResourcesScrapper.ResOnlineConvert;
import ResourcesScrapper.ResWebopedia;

public class CreateDatabase {
	static DatabaseCon con;

	public static void webopediaIntoDB() {
		try {
			new ResWebopedia().fetchExtensions();
			System.out.println("Starting Connection...\n");

			DatabaseCon.session.beginTransaction();
			System.out.println("Inserting...\n");

			for (String ext : ResWebopedia.extensions)
				DatabaseCon.session.save(new Files(ext));

			DatabaseCon.session.getTransaction().commit();
			System.out.println("Insertion Completed.");

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			DatabaseCon.factory.close();
		}
	}

	public static void onlineConvertIntoDB() {
		try {
			new ResOnlineConvert().fetchReosurces();
			System.out.println("Starting Connection...\n");

			DatabaseCon.session.beginTransaction();
			System.out.println("Inserting...\n");

			for (Files file : ResOnlineConvert.detailsOfExtension)
				DatabaseCon.session.save(file);

			DatabaseCon.session.getTransaction().commit();
			System.out.println("Insertion Completed.");

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			DatabaseCon.factory.close();
		}
	}

	public static void main(String[] args) {
		new DatabaseCon();
		try {
			DatabaseCon.startSession();
			/**
			 * adding available list of extensions only from webopedia.com around 3100
			 * Extensions are fetched from webopedio.com
			 **/
			webopediaIntoDB();

			/**
			 * adding list of extension and its available details : CATEGORY , APPLICATION,
			 * AND AUTHOR from online-convert.com
			 **/
			onlineConvertIntoDB();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseCon.closeSession();
			System.gc();
		}

	}

}
