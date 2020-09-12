package org.application.definemodule.persistence.PostgresImpl;

import org.application.definemodule.persistence.postgresdao.*;
import org.application.generatemodule.persistence.PostgresDao.PersonDao;
import org.application.generatemodule.persistence.PostgresImpl.PersonDaoPostgresImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PostgresDaoImplProvider extends HibernateUtil implements DaoProvider {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManagerFactory entityManagerFactoryTarget;
    private OperatorDao operatorDao;
    private TableDao tableDao;
    private BusinessRuleDao businessRuleDao;
    private BusinessRuleTypeDao businessRuleTypeDao;
    private BusinessRuleTypeOperatorDao businessRuleTypeOperatorDao;
    private CategoryDao categoryDao;
    private ColumnDao columnDao;
    private DatabaseDao databaseDao;
    private ValueDefinitionDao valueDefinitionDao;
    private PersonDao personDao;

    public PostgresDaoImplProvider() {
        EntityManager entityManager = null;
        EntityManager entityManagerTarget = null;
        try {
            entityManagerFactory = HibernateUtil.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityManagerTarget = entityManagerFactory.createEntityManager();
            operatorDao = new OperatorDaoPostgresImpl(entityManager);
            tableDao = new TableDaoPostgresImpl(entityManager);
            businessRuleDao = new BusinessRuleDaoPostgresImpl(entityManager);
            businessRuleTypeDao = new BusinessRuleTypeDaoPostgresImpl(entityManager);
            categoryDao = new CategoryDaoPostgresImpl(entityManager);
            columnDao = new ColumnDaoPostgresImpl(entityManager);
            databaseDao = new DatabaseDaoPostgresImpl(entityManager);
            valueDefinitionDao = new ValueDefinitionDaoPostgresImpl(entityManager);
            personDao = new PersonDaoPostgresImpl(entityManager);
            businessRuleTypeOperatorDao = new BusinessRuleTypeOperatorDaoPostgresImpl(entityManager);
        }catch (Throwable ex){
            System.err.println("Failed to create entitymanager object." + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }

    @Override
    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    @Override
    public TableDao getTableDao() {
        return tableDao;
    }

    @Override
    public BusinessRuleDao getBusinessRuleDao() {
        return businessRuleDao;
    }

    @Override
    public BusinessRuleTypeDao getBusinessRuleTypeDao() {
        return businessRuleTypeDao;
    }

    @Override
    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    @Override
    public ColumnDao getColumnDao() {
        return columnDao;
    }

    @Override
    public DatabaseDao getDatabaseDao() {
        return databaseDao;
    }

    @Override
    public PersonDao getPersonDao(){return personDao;}

    @Override
    public BusinessRuleTypeOperatorDao getBusinessRuleTypeOperatorDao() {
        return businessRuleTypeOperatorDao;
    }

    @Override
    public ValueDefinitionDao getValueDefinitionDao() {
        return valueDefinitionDao;
    }
}
