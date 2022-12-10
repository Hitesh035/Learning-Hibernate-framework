package com.hitesh.quickshop.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SessionFactoryGiver {

	public static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			
			sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory;
		}
		return sessionFactory;
	}
}
