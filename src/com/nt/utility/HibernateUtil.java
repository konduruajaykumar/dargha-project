package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	static {
		try {
			// create SessionFactory object
			factory = new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		Session ses = null;
		if (threadLocal.get() == null) {
			ses = factory.openSession();
			threadLocal.set(ses);
			System.out.println("Session created..");
			return ses;
		} else {
			ses = threadLocal.get();
			System.out.println("Already created Session is given back ..");
			return ses;
		}

	}// getSession()

	public static void closeSesion() {
		Session ses = null;
		if (threadLocal.get() != null) {
			ses = threadLocal.get();
			threadLocal.remove();
			ses.close();
			System.out.println("Session closed..");
		}
	}// closeSession()

	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
		System.out.println("SessionFactory closed..");
	}// closeSessionFactory()
}// class
