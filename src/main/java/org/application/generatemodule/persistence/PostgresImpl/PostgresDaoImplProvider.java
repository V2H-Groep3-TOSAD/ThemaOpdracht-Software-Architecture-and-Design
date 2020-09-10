package org.application.generatemodule.persistence.PostgresImpl;

import org.application.definemodule.persistence.postgresdao.*;
import org.application.generatemodule.persistence.PostgresDao.AddressDao;
import org.application.generatemodule.persistence.PostgresDao.PersonDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PostgresDaoImplProvider extends HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;
    private PersonDao personDao;
    private AddressDao addressDao;
    private TriggerDaoPostgresImpl triggerDao;

    public PostgresDaoImplProvider(){
        EntityManager entityManager = null;
        try {
            entityManagerFactory = HibernateUtil.getEntityManagerFactoryTarget();
            entityManager = entityManagerFactory.createEntityManager();
            personDao = new PersonDaoPostgresImpl(entityManager);
            addressDao = new AddressDaoPostgresImpl(entityManager);
            triggerDao = new TriggerDaoPostgresImpl(entityManager);
        }catch (Throwable ex){
            System.err.println("Failed to create entitymanager object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public PersonDao getPersonDao(){return personDao;}
    public AddressDao getAddressDao(){return addressDao;}

    public TriggerDaoPostgresImpl getTriggerDao() {
        return triggerDao;
    }
}
