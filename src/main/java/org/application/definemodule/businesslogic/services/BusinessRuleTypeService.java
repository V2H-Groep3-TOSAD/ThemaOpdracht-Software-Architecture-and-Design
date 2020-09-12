package org.application.definemodule.businesslogic.services;

import org.application.domain.BusinessRuleType;
import org.application.definemodule.persistence.postgresdao.BusinessRuleTypeDao;

public class BusinessRuleTypeService extends AbstractService<BusinessRuleType> {
//    extends
//} AbstractPostgresServiceImpl<BusinessRuleType> implements BusinessRuleTypeService {
//    public BusinessRuleTypePostgresService(BusinessRuleTypeDao businessRuleTypeDao) {
//        super(businessRuleTypeDao);
//    };
//
//    private BusinessRuleTypeDao businessRuleTypeDao;
//
    public BusinessRuleTypeService(BusinessRuleTypeDao businessRuleTypeDao){
        super(businessRuleTypeDao);
    };

//
//    public void saveOrUpdate(BusinessRuleType businessRuleType){
//        businessRuleTypeDao.insert(businessRuleType);
//    };
//
//    public List<BusinessRuleType> getAllBusinessRuleTypes(){
//        return businessRuleTypeDao.getAll();
//    };
//
//    public BusinessRuleType getBusinessRuleTypeById(int id){
//        return businessRuleTypeDao.findById(id);
//    };
}
