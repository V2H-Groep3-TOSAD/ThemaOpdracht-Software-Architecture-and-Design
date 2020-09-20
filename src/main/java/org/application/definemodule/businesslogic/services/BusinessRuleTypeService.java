package org.application.definemodule.businesslogic.services;

import org.application.domain.BusinessRuleType;
import org.application.definemodule.persistence.postgresdao.BusinessRuleTypeDao;

import java.util.List;

public class BusinessRuleTypeService {
//    extends
//} AbstractPostgresServiceImpl<BusinessRuleType> implements BusinessRuleTypeService {
//    public BusinessRuleTypePostgresService(BusinessRuleTypeDao businessRuleTypeDao) {
//        super(businessRuleTypeDao);
//    };
//
    private final BusinessRuleTypeDao businessRuleTypeDao;

    public BusinessRuleTypeService(BusinessRuleTypeDao businessRuleTypeDao){
        this.businessRuleTypeDao = businessRuleTypeDao;
    };

    public BusinessRuleType getBusinessRuleTypeByName(String name) {
        return businessRuleTypeDao.findByName(name);
    };

    public void saveOrUpdate(BusinessRuleType businessRuleType){
        businessRuleTypeDao.insert(businessRuleType);
    };

    public List<BusinessRuleType> getAllBusinessRuleTypes(){
        return businessRuleTypeDao.getAll();
    };

    public BusinessRuleType getBusinessRuleTypeById(int id){
        return businessRuleTypeDao.findById(id);
    };
}
