package org.application.definemodule.persistence.PostgresImpl;

import org.application.domain.BusinessRule;
import org.application.definemodule.persistence.postgresdao.BusinessRuleDao;

import javax.persistence.EntityManager;

public class BusinessRuleDaoPostgresImpl extends AbstractDaoPostgresImpl<BusinessRule> implements BusinessRuleDao {
    public BusinessRuleDaoPostgresImpl(EntityManager entityManager) {super(entityManager);}
}
