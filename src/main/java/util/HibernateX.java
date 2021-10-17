package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateX {
	
	static Session sess;
	static Configuration cfg= new Configuration().configure("hibernate.cfg.xml");
	static SessionFactory sf= cfg.buildSessionFactory();
	
	public static Session getsession()
	{
		
		//cfg.configure("hibernate.cfg.xml");
		
		//SessionFactory sf=cfg.buildSessionFactory();
		
		if(sess==null||sess.isOpen()==false)
		{
		sf= cfg.buildSessionFactory();
		sess=sf.openSession();
		return(sess);
		}
		else {
			System.out.println("CHECK POINT");
			return sess;
		}
	}

}

