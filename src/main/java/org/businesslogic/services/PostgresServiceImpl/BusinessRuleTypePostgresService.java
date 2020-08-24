package org.businesslogic.services.PostgresServiceImpl;

import org.businesslogic.domain.BusinessRuleType;
import org.persistence.postgresdao.BusinessRuleTypeDao;
import org.businesslogic.services.postgresservice.BusinessRuleTypeService;

public class BusinessRuleTypePostgresService extends AbstractPostgresServiceImpl<BusinessRuleType> implements BusinessRuleTypeService {
    public BusinessRuleTypePostgresService(BusinessRuleTypeDao businessRuleTypeDao) {
        super(businessRuleTypeDao);
    };


}
