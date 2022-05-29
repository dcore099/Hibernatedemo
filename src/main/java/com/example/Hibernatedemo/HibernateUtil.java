package com.example.Hibernatedemo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	public static SessionFactory factory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		if(factory == null) {
			StandardServiceRegistry stRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			
			Metadata metaData = new MetadataSources(stRegistry).getMetadataBuilder().build();
			
			factory = metaData.getSessionFactoryBuilder().build();
		}
		return factory;
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
	
}
