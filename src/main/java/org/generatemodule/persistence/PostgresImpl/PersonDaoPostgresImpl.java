package org.generatemodule.persistence.PostgresImpl;

import org.definemodule.persistence.PostgresImpl.AbstractDaoPostgresImpl;
import org.definemodule.persistence.postgresdao.HibernateUtil;
import org.generatemodule.businesslogic.targetdomain.Person;
import org.generatemodule.persistence.PostgresDao.PersonDao;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonDaoPostgresImpl extends AbstractDaoPostgresImpl<Person> implements PersonDao {
    private static SessionFactory factory;

    public PersonDaoPostgresImpl(EntityManager entityManager){
        super(entityManager);
    }

    @Override
    public List<Person> findByName(String name){
        @SuppressWarnings("unchecked")
        List<Person> persons = (List<Person>) em
                .createQuery("from Person where name=" + name).getResultList();
        if (!persons.isEmpty()) {
            System.out.println(persons);
            return persons;
        }
        return null;
    }

    public void executeTrigger (String triggerQuery) {

        System.out.println(" test : " + triggerQuery);

//        Query q = em.createNativeQuery(triggerQuery);

        em.createNativeQuery(triggerQuery);

//        q.executeUpdate();

//        em.getTransaction().commit();


//        em.createNativeQuery("BEGIN " + triggerQuery + " END;");


//        Session session = Hibernate.util.HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        String sql = String.format("INSERT INTO products (name,cost) VALUES('%s',%s);",product.getName(), product.getCost());
//        session.createSQLQuery(sql).executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//
//        session.createSQLQuery(sql).executeUpdate();




//        try {
//            factory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//
////        return factory.openSession();
//
//        Session session = factory.openSession();
//
//        Transaction transaction = session.beginTransaction();
//        session.createQuery(triggerQuery);
////        session.getTransaction().commit();
//
//
//        System.out.println(" test : " + triggerQuery);
//        transaction.commit();
    }


}
