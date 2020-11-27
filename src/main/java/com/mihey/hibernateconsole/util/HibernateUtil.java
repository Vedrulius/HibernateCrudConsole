package com.mihey.hibernateconsole.util;

import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static Session session;

    public static void setSession() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            session = metadata.getSessionFactoryBuilder().build().openSession();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return session;
    }

    public static void closeSession() {
        try {
            if (session != null) {
                session.close();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
