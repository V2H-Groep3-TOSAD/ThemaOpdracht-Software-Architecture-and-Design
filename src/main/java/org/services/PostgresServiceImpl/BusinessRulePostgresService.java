package org.services.PostgresServiceImpl;

import org.business.domain.BusinessRule;
import org.persistence.BusinessRuleDao;
import org.persistence.PostgresImpl.PostgresDaoImplProvider;

import java.util.List;

public class BusinessRulePostgresService {
//        extends AbstractPostgresServiceImpl<BusinessRule> implements BusinessRuleService {
//
//    public BusinessRulePostgresService(BusinessRuleDao businessRuleDao){
//        super(businessRuleDao);
//    };
    private BusinessRuleDao businessRuleDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public BusinessRulePostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        businessRuleDao = postgresDaoImplProvider.getBusinessRuleDao();
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
