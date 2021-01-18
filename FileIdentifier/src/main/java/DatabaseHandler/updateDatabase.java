package DatabaseHandler;

import ResourcesScrapper.ResFileInfo;

public class updateDatabase {

	public static void main(String[] args) {
		new DatabaseCon();
		try {
			DatabaseCon.startSession();
			DatabaseCon.session.beginTransaction();
			
			Files file = DatabaseCon.session.get(Files.class,"doc");
			new ResFileInfo("doc");
			file.setDescription(ResFileInfo.fetchDescription());
			file.setFormat(ResFileInfo.fetchFormat());
			
			DatabaseCon.session.update(file);
			System.out.println("Details....\n"+file.toString());
			
			DatabaseCon.session.getTransaction().commit(); 
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DatabaseCon.closeSession();
			System.gc();
		}
		
	}

}
