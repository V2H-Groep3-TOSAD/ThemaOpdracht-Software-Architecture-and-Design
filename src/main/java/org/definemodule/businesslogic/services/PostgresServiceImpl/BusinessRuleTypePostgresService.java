package org.definemodule.businesslogic.services.PostgresServiceImpl;

import org.domain.BusinessRuleType;
import org.definemodule.persistence.postgresdao.BusinessRuleTypeDao;
import org.definemodule.persistence.postgresdaoimpl.PostgresDaoImplProvider;

import java.util.List;

public class BusinessRuleTypePostgresService {
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