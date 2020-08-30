package org.generatemodule.persistence.PostgresImpl;

import org.definemodule.persistence.postgresdao.*;
import org.generatemodule.persistence.PostgresDao.AddressDao;
import org.generatemodule.persistence.PostgresDao.PersonDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PostgresDaoImplProvider extends HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;
    private PersonDao personDao;
    private AddressDao addressDao;

    public PostgresDaoImplProvider(){
        EntityManager entityManager = null;
        try {
            entityManagerFactory = HibernateUtil.getEntityManagerFactoryTarget();
            entityManager = entityManagerFactory.createEntityManager();
            personDao = new PersonDaoPostgresImpl(entityManager);
            addressDao = new AddressDaoPostgresImpl(entityManager);
        }catch (Throwable ex){
            System.err.println("Failed to create entitymanager object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public PersonDao getPersonDao(){return personDao;}
    public AddressDao getAddressDao(){return addressDao;}
}
