package org.application.definemodule.businesslogic.services.postgresserviceimpl;

import org.application.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
import org.application.definemodule.persistence.postgresdao.BusinessRuleTypeOperatorDao;
import org.application.domain.BusinessRuleType;
import org.application.domain.BusinessRuleTypeOperator;

import java.util.List;

public class BusinessRuleTypeOperatorPostgresService {
    private BusinessRuleTypeOperatorDao businessRuleTypeOperatorDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public BusinessRuleTypeOperatorPostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        businessRuleTypeOperatorDao = postgresDaoImplProvider.getBusinessRuleTypeOperatorDao();
    };

    public List<BusinessRuleTypeOperator> getBusinessRuleTypeOperators(BusinessRuleType businessRuleType) {
        return businessRuleTypeOperatorDao.getAllOperatorsByBusinessRuleType(businessRuleType);
    };
}
