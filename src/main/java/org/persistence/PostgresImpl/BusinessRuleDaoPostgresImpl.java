package org.persistence.PostgresImpl;

import org.domain.BusinessRule;
import org.persistence.BusinessRuleDao;

import javax.persistence.EntityManager;

public class BusinessRuleDaoPostgresImpl extends AbstractDaoPostgresImpl<BusinessRule> implements BusinessRuleDao {
    public BusinessRuleDaoPostgresImpl(EntityManager entityManager) {super(entityManager);}
}
