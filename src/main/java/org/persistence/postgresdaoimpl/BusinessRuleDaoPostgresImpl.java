package org.persistence.postgresdaoimpl;

import org.businesslogic.domain.BusinessRule;
import org.persistence.postgresdao.BusinessRuleDao;

import javax.persistence.EntityManager;

public class BusinessRuleDaoPostgresImpl extends AbstractDaoPostgresImpl<BusinessRule> implements BusinessRuleDao {
    public BusinessRuleDaoPostgresImpl(EntityManager entityManager) {super(entityManager);}
}
