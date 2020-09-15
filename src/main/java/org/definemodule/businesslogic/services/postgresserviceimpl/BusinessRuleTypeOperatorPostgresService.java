//package org.definemodule.businesslogic.services.postgresserviceimpl;
//
//import org.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
//import org.definemodule.persistence.postgresdao.BusinessRuleTypeDao;
//import org.definemodule.persistence.postgresdao.BusinessRuleTypeOperatorDao;
//import org.domain.BusinessRule;
//import org.domain.BusinessRuleType;
//import org.domain.BusinessRuleTypeOperator;
//
//import java.util.List;
//
//public class BusinessRuleTypeOperatorPostgresService {
//    private BusinessRuleTypeOperatorDao businessRuleTypeOperatorDao;
//    private PostgresDaoImplProvider postgresDaoImplProvider;
//
//    public BusinessRuleTypeOperatorPostgresService(){
//        postgresDaoImplProvider = new PostgresDaoImplProvider();
//        businessRuleTypeOperatorDao = postgresDaoImplProvider.getBusinessRuleTypeOperatorDao();
//    };
//
//    public List<BusinessRuleTypeOperator> getBusinessRuleTypeOperators(BusinessRuleType businessRuleType) {
//        return businessRuleTypeOperatorDao.getAllOperatorsByBusinessRuleType(businessRuleType);
//    };
//}
