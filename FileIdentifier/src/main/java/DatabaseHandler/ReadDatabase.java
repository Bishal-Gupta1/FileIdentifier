package DatabaseHandler;

public class ReadDatabase {

	public ReadDatabase() {
		new DatabaseCon();
	}

	public static Files Read(String extension) throws Exception {
		Files file = null;
		new DatabaseCon();
		DatabaseCon.startSession();
		DatabaseCon.session.beginTransaction();
		
		file = DatabaseCon.session.get(Files.class, extension);
		DatabaseCon.closeSessionFactory();
		
		return file;
	}

}
