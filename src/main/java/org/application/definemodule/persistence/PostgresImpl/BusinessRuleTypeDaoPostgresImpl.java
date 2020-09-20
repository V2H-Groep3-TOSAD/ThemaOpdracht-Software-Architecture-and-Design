package org.application.definemodule.persistence.PostgresImpl;

import org.application.domain.BusinessRuleType;
import org.application.definemodule.persistence.postgresdao.BusinessRuleTypeDao;

import javax.persistence.EntityManager;

public class BusinessRuleTypeDaoPostgresImpl extends AbstractDaoPostgresImpl<BusinessRuleType> implements BusinessRuleTypeDao {
    public BusinessRuleTypeDaoPostgresImpl(EntityManager entityManager){super(entityManager);}

    @Override
    public BusinessRuleType findByName(String name) {
        BusinessRuleType businessRuleType = (BusinessRuleType) em.createQuery("from BusinessRuleType where name = '" + name + "'").getSingleResult();
        return businessRuleType;
    }
}
