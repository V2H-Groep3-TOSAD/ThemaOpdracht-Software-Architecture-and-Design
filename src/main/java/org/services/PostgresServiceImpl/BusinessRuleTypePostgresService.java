package org.services.PostgresServiceImpl;

import org.business.domain.BusinessRuleType;
import org.persistence.BusinessRuleTypeDao;
import org.persistence.PostgresImpl.PostgresDaoImplProvider;

import java.util.List;

public class BusinessRuleTypePostgresService {
//    extends
//} AbstractPostgresServiceImpl<BusinessRuleType> implements BusinessRuleTypeService {
//    public BusinessRuleTypePostgresService(BusinessRuleTypeDao businessRuleTypeDao) {
//        super(businessRuleTypeDao);
//    };

    private BusinessRuleTypeDao businessRuleTypeDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public BusinessRuleTypePostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        businessRuleTypeDao = postgresDaoImplProvider.getBusinessRuleTypeDao();
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
