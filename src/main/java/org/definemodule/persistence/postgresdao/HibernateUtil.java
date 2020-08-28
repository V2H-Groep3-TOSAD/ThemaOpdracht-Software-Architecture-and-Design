package org.definemodule.persistence.postgresdao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    //    public static final SessionFactory sessionFactory;
//
//    static {
//        try {
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//            System.out.println("sessionFactory gemaakt");
//        } catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
    private static String postgres = "hibernate.postgres";
    private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(postgres);

        } catch (Throwable th) {
            System.err.println("Initial EntityManagerFactory creation failed"
                    + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
