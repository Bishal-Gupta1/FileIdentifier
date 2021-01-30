package DatabaseHandler;

public class updateDatabase {
	/**
	 * Extensions are first fetched from WeboPedia.com and its related details are
	 * fetched from FileInfo.com
	 * 
	 */
	public static void updateExtDetails_Webopedia() {

	}

	public static void main(String[] args) {
		new DatabaseCon();
		try {
			DatabaseCon.startSession();
			DatabaseCon.session.beginTransaction();

			System.out.println("Fetching Extensions....\n");
			
			//deprecated
		    
//			List<String> exts = new ArrayList<String>(new ResOnlineConvert().fetchResources());
////			System.out.println(".\n.\n.\nExtensions Fetched\n");
////
////			for (String ext : exts) {
////				ResFileInfo fileInfo = new ResFileInfo(ext);
////				Files file = DatabaseCon.session.get(Files.class, ext);
////				if (file == null)
////					continue;
////				System.out.println(ext + " Updating Database....\n");
////				file.setDescription(fileInfo.getDescription());
////				file.setFormat(fileInfo.getFormat());
////			}
			DatabaseCon.session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseCon.closeSessionFactory();
			System.gc();

		}

	}

}
