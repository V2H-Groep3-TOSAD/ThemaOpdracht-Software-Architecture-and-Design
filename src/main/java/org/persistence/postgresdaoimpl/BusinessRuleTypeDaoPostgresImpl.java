package org.persistence.postgresdaoimpl;

import org.businesslogic.domain.BusinessRuleType;
import org.persistence.postgresdao.BusinessRuleTypeDao;

import javax.persistence.EntityManager;

public class BusinessRuleTypeDaoPostgresImpl extends AbstractDaoPostgresImpl<BusinessRuleType> implements BusinessRuleTypeDao {
    public BusinessRuleTypeDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
