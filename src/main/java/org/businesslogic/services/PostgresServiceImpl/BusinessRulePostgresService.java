package org.businesslogic.services.PostgresServiceImpl;

import org.businesslogic.domain.BusinessRule;
import org.persistence.postgresdao.BusinessRuleDao;
import org.businesslogic.services.postgresservice.BusinessRuleService;

public class BusinessRulePostgresService extends AbstractPostgresServiceImpl<BusinessRule> implements BusinessRuleService {

    public BusinessRulePostgresService(BusinessRuleDao businessRuleDao){
        super(businessRuleDao);
    };

}
