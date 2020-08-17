package org.services.PostgresServiceImpl;

import org.domain.BusinessRuleType;
import org.persistence.BusinessRuleTypeDao;
import org.persistence.PostgresImpl.PostgresImplService;
import org.services.BusinessRuleTypeService;

import java.util.List;

public class BusinessRuleTypePostgresService extends AbstractPostgresServiceImpl<BusinessRuleType> implements BusinessRuleTypeService {
    public BusinessRuleTypePostgresService(BusinessRuleTypeDao businessRuleTypeDao) {
        super(businessRuleTypeDao);
    };


}
