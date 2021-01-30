package DatabaseHandler;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseCon {

	public static Session session;
	private static SessionFactory factory;

	public DatabaseCon() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Files.class)
				.buildSessionFactory();	
	}

	public static void startSession(){		
		session = factory.getCurrentSession();
	}

	public static void closeSessionFactory() {
		factory.close();
	}
}