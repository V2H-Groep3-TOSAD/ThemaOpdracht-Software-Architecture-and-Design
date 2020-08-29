package org.definemodule.persistence.PostgresImpl;

import org.domain.BusinessRule;
import org.definemodule.persistence.postgresdao.BusinessRuleDao;

import javax.persistence.EntityManager;

public class BusinessRuleDaoPostgresImpl extends AbstractDaoPostgresImpl<BusinessRule> implements BusinessRuleDao {
    public BusinessRuleDaoPostgresImpl(EntityManager entityManager) {super(entityManager);}
}
