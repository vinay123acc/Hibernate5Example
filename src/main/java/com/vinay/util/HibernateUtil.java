package com.vinay.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.vinay.entity.Course;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static SessionFactory getSessionFactory(){
		
		if(null==sessionFactory){
			
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
													   .configure("/hibernate.cfg.xml" )
													   .build();

			Metadata metadata = new MetadataSources(standardRegistry)
					.addAnnotatedClass(Course.class)
					.getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
					.build();

			sessionFactory= metadata.getSessionFactoryBuilder()
					.build();
			
		}
		return sessionFactory;
	}
	
	public static Session getSession(){
		if(null==session){
			session= getSessionFactory().openSession();
		}
		return session;
	}
}
