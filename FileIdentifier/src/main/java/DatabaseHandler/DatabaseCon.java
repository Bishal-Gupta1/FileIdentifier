package DatabaseHandler;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseCon {

	static Session session;
	public static SessionFactory factory;

	public DatabaseCon() {
         /** no-arg constructor  */	
	}

	public static void startSession(){
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Files.class)
				.buildSessionFactory();
		session = factory.getCurrentSession();
	}

	public static void closeSession() {
		factory.close();
	}
}