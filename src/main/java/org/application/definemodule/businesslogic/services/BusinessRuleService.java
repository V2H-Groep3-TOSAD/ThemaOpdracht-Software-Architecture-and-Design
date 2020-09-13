package org.application.definemodule.businesslogic.services;

import org.application.domain.BusinessRule;
import org.application.definemodule.persistence.postgresdao.BusinessRuleDao;

import java.util.List;

public class BusinessRuleService {
        //extends AbstractService<BusinessRule>{

    private final BusinessRuleDao businessRuleDao;

    public BusinessRuleService(BusinessRuleDao businessRuleDao){
       this.businessRuleDao = businessRuleDao;
    };

    public void saveOrUpdate(BusinessRule businessRule){
        businessRuleDao.insert(businessRule);
    };

    public List<BusinessRule> getAllBusinessRules(){
        return businessRuleDao.getAll();
    };

    public BusinessRule getBusinessRuleById(int id){
        return businessRuleDao.findById(id);
    };


}
