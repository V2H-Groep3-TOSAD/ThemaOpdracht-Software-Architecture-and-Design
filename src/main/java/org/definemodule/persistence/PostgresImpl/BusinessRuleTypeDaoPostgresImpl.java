package org.definemodule.persistence.PostgresImpl;

import org.domain.BusinessRuleType;
import org.definemodule.persistence.postgresdao.BusinessRuleTypeDao;
import org.domain.Column;

import javax.persistence.EntityManager;
import java.util.List;

public class BusinessRuleTypeDaoPostgresImpl extends AbstractDaoPostgresImpl<BusinessRuleType> implements BusinessRuleTypeDao {
    public BusinessRuleTypeDaoPostgresImpl(EntityManager entityManager){super(entityManager);}


    @Override
    public BusinessRuleType findByName(String name) {
        BusinessRuleType businessRuleType = (BusinessRuleType) em.createQuery("from BusinessRuleType where name = '" + name + "'").getSingleResult();
        return businessRuleType;
    }

}
