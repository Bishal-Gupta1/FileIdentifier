package DatabaseHandler;

public class ReadDatabase {

	public static void main(String[] args) {
		new DatabaseCon();
		try {
			DatabaseCon.startSession();
			
			DatabaseCon.session.beginTransaction();
			Files file = DatabaseCon.session.get(Files.class,"doc");
			
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
