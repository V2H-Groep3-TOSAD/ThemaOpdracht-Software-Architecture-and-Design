package org.application.definemodule.businesslogic.services;

import org.application.definemodule.persistence.postgresdao.BusinessRuleTypeOperatorDao;
import org.application.domain.BusinessRuleTypeOperator;

public class BusinessRuleTypeOperatorService extends AbstractService<BusinessRuleTypeOperator> {
//    private final BusinessRuleTypeOperatorDao businessRuleTypeOperatorDao;

    public BusinessRuleTypeOperatorService(BusinessRuleTypeOperatorDao businessRuleTypeOperatorDao){
        super(businessRuleTypeOperatorDao);
    };

//    public List<BusinessRuleTypeOperator> getBusinessRuleTypeOperators(BusinessRuleType businessRuleType) {
//        return businessRuleTypeOperatorDao.getAllOperatorsByBusinessRuleType(businessRuleType);
//    };
}
