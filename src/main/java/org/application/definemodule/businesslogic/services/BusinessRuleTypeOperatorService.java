package org.application.definemodule.businesslogic.services;

import org.application.definemodule.persistence.postgresdao.BusinessRuleTypeOperatorDao;
import org.application.domain.BusinessRuleType;
import org.application.domain.BusinessRuleTypeOperator;

import java.util.List;

public class BusinessRuleTypeOperatorService {
        //extends AbstractService<BusinessRuleTypeOperator> {
    private BusinessRuleTypeOperatorDao businessRuleTypeOperatorDao;

    public BusinessRuleTypeOperatorService(BusinessRuleTypeOperatorDao businessRuleTypeOperatorDao){
        this.businessRuleTypeOperatorDao = businessRuleTypeOperatorDao;
    };

//    public BusinessRuleTypeOperatorService(BusinessRuleTypeOperatorDao businessRuleTypeOperatorDao){
//        super(businessRuleTypeOperatorDao);
//    };

    public List<BusinessRuleTypeOperator> getBusinessRuleTypeOperators(BusinessRuleType businessRuleType) {
        return businessRuleTypeOperatorDao.getAllOperatorsByBusinessRuleType(businessRuleType);
    };
}
