package org.definemodule.persistence.PostgresImpl;

import org.domain.BusinessRuleType;
import org.definemodule.persistence.postgresdao.BusinessRuleTypeDao;

import javax.persistence.EntityManager;

public class BusinessRuleTypeDaoPostgresImpl extends AbstractDaoPostgresImpl<BusinessRuleType> implements BusinessRuleTypeDao {
    public BusinessRuleTypeDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
