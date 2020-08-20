package org.services.PostgresServiceImpl;

import org.domain.BusinessRule;
import org.persistence.BusinessRuleDao;
import org.persistence.PostgresImpl.BusinessRuleDaoPostgresImpl;
import org.persistence.PostgresImpl.PostgresImplService;
import org.services.BusinessRuleService;

import java.util.List;

public class BusinessRulePostgresService {
//        extends AbstractPostgresServiceImpl<BusinessRule> implements BusinessRuleService {
//
//    public BusinessRulePostgresService(BusinessRuleDao businessRuleDao){
//        super(businessRuleDao);
//    };
    private BusinessRuleDao businessRuleDao;
    private PostgresImplService postgresImplService;

    public BusinessRulePostgresService(){
        postgresImplService = new PostgresImplService();
        businessRuleDao = postgresImplService.getBusinessRuleDao();
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
