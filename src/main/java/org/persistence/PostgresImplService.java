package org.persistence;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PostgresImplService extends HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;
    private OperatorDao operatorDao;

    public PostgresImplService(){
        EntityManager entityManager = null;
        try {
            entityManagerFactory = HibernateUtil.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            operatorDao = new OperatorDaoPostgresImpl(entityManager);
        }catch (Throwable ex){
            System.err.println("Failed to create entitymanager object." + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }
}
