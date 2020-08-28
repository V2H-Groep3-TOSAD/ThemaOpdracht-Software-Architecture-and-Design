package org.persistence.PostgresImpl;

import org.business.domain.tool.BusinessRuleType;
import org.persistence.BusinessRuleTypeDao;

import javax.persistence.EntityManager;

public class BusinessRuleTypeDaoPostgresImpl extends AbstractDaoPostgresImpl<BusinessRuleType> implements BusinessRuleTypeDao {
    public BusinessRuleTypeDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
