package org.definemodule.persistence.PostgresImpl;

import org.definemodule.persistence.postgresdao.BusinessRuleTypeDao;
import org.definemodule.persistence.postgresdao.BusinessRuleTypeOperatorDao;
import org.domain.BusinessRuleType;
import org.domain.BusinessRuleTypeOperator;

import javax.persistence.EntityManager;
import java.util.List;

public class BusinessRuleTypeOperatorDaoPostgresImpl extends AbstractDaoPostgresImpl<BusinessRuleTypeOperator> implements BusinessRuleTypeOperatorDao {
    public BusinessRuleTypeOperatorDaoPostgresImpl(EntityManager entityManager){super(entityManager);}

    @Override
    public List<BusinessRuleTypeOperator> getAllOperatorsByBusinessRuleType(BusinessRuleType businessRuleType) {
        List<BusinessRuleTypeOperator> businessRuleTypeOperators = (List<BusinessRuleTypeOperator>) em.createQuery("from BusinessRuleTypeOperator where businessruletype_id" + businessRuleType.getId()).getResultList();
        if(!businessRuleTypeOperators.isEmpty()){
            System.out.println(businessRuleTypeOperators);
            return businessRuleTypeOperators;
        }
        return null;
    }
}
