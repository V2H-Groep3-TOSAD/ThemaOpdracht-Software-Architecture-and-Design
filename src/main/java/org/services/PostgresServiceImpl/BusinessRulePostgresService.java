package org.services.PostgresServiceImpl;

import org.domain.BusinessRule;
import org.persistence.BusinessRuleDao;
import org.persistence.PostgresImpl.BusinessRuleDaoPostgresImpl;
import org.persistence.PostgresImpl.PostgresImplService;
import org.services.BusinessRuleService;

import java.util.List;

public class BusinessRulePostgresService extends AbstractPostgresServiceImpl<BusinessRule> implements BusinessRuleService {

    public BusinessRulePostgresService(BusinessRuleDao businessRuleDao){
        super(businessRuleDao);
    };

}
