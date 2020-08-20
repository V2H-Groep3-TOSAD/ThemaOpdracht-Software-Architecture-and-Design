package org.services.PostgresServiceImpl;

import org.domain.BusinessRuleType;
import org.persistence.BusinessRuleTypeDao;
import org.persistence.PostgresImpl.PostgresImplService;
import org.services.BusinessRuleTypeService;

import java.util.List;

public class BusinessRuleTypePostgresService {
//    extends
//} AbstractPostgresServiceImpl<BusinessRuleType> implements BusinessRuleTypeService {
//    public BusinessRuleTypePostgresService(BusinessRuleTypeDao businessRuleTypeDao) {
//        super(businessRuleTypeDao);
//    };

    private BusinessRuleTypeDao businessRuleTypeDao;
    private PostgresImplService postgresImplService;

    public BusinessRuleTypePostgresService(){
        postgresImplService = new PostgresImplService();
        businessRuleTypeDao = postgresImplService.getBusinessRuleTypeDao();
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
