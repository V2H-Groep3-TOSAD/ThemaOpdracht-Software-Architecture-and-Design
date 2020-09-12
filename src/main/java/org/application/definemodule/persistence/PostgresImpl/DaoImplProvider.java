package org.application.definemodule.persistence.PostgresImpl;

import org.application.definemodule.persistence.postgresdao.*;
import org.application.generatemodule.persistence.PostgresDao.PersonDao;
import org.application.generatemodule.persistence.PostgresImpl.PersonDaoPostgresImpl;

import javax.persistence.EntityManager;

public class DaoImplProvider implements DaoProvider {
    private EntityManager entityManager;

    @Override
    public OperatorDao getOperatorDao() {
        return new OperatorDaoPostgresImpl(entityManager);
    }

    @Override
    public TableDao getTableDao() {
        return new TableDaoPostgresImpl(entityManager);
    }

    @Override
    public BusinessRuleDao getBusinessRuleDao() {
        return new BusinessRuleDaoPostgresImpl(entityManager);
    }

    @Override
    public BusinessRuleTypeDao getBusinessRuleTypeDao() {
        return new BusinessRuleTypeDaoPostgresImpl(entityManager);
    }

    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoPostgresImpl(entityManager);
    }

    @Override
    public ColumnDao getColumnDao() {
        return new ColumnDaoPostgresImpl(entityManager);
    }

    @Override
    public DatabaseDao getDatabaseDao() {
        return new DatabaseDaoPostgresImpl(entityManager);
    }

    @Override
    public PersonDao getPersonDao() {
        return new PersonDaoPostgresImpl(entityManager);
    }

    @Override
    public BusinessRuleTypeOperatorDao getBusinessRuleTypeOperatorDao() {
        return new BusinessRuleTypeOperatorDaoPostgresImpl(entityManager);
    }

    @Override
    public ValueDefinitionDao getValueDefinitionDao() {
        return new ValueDefinitionDaoPostgresImpl(entityManager);
    }
}
