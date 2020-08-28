package org.definemodule.persistence.postgresdaoimpl;

import org.definemodule.persistence.postgresdao.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PostgresDaoImplProvider extends HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;
    private OperatorDao operatorDao;
    private TableDao tableDao;
    private BusinessRuleDao businessRuleDao;
    private BusinessRuleTypeDao businessRuleTypeDao;
    private CategoryDao categoryDao;
    private ColumnDao columnDao;
    private DatabaseDao databaseDao;
    private ValueDefinitionDao valueDefinitionDao;

    public PostgresDaoImplProvider(){
        EntityManager entityManager = null;
        try {
            entityManagerFactory = HibernateUtil.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            operatorDao = new OperatorDaoPostgresImpl(entityManager);
            tableDao = new TableDaoPostgresImpl(entityManager);
            businessRuleDao = new BusinessRuleDaoPostgresImpl(entityManager);
            businessRuleTypeDao = new BusinessRuleTypeDaoPostgresImpl(entityManager);
            categoryDao = new CategoryDaoPostgresImpl(entityManager);
            columnDao = new ColumnDaoPostgresImpl(entityManager);
            databaseDao = new DatabaseDaoPostgresImpl(entityManager);
            valueDefinitionDao = new ValueDefinitionDaoPostgresImpl(entityManager);
        }catch (Throwable ex){
            System.err.println("Failed to create entitymanager object." + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }

    public TableDao getTableDao() {
        return tableDao;
    }

    public BusinessRuleDao getBusinessRuleDao() {
        return businessRuleDao;
    }

    public BusinessRuleTypeDao getBusinessRuleTypeDao() {
        return businessRuleTypeDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public ColumnDao getColumnDao() {
        return columnDao;
    }

    public DatabaseDao getDatabaseDao() {
        return databaseDao;
    }

    public ValueDefinitionDao getValueDefinitionDao() {
        return valueDefinitionDao;
    }
}
