package org.presentation;

import org.hibernate.SessionFactory;

public class TestTargetTrigger {
    private static SessionFactory factory;
    public static void main(String[] args) {

//        try {
//            factory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//        Session session = factory.openSession();
//    }
//
//    Session session = factory.openSession();
//    Transaction t = session.beginTransaction();
//
//    private String queryString =   "create or replace trigger ? " +
//            "before insert on ? " +
//            "for each row begin if :new.? != ? " +
//            "then SQLSTATE '22000' SET MESSAGE_TEXT = 'De waarde is niet gelijk'; " +
//            "end if; " +
//            "end;";
//
//    Query query = session.createSQLQuery(queryString);
//
//    t.commit();
//    factory.close();
//    session.close();

    }

}
