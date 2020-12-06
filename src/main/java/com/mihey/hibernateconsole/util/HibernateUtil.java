package com.mihey.hibernateconsole.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private final static SessionFactory sessionFactory = setSession();

    public static SessionFactory  setSession() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
           return metadata.buildSessionFactory();
        } catch (Throwable e) {
            e.printStackTrace();
            return  null;
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory() {
        try {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
