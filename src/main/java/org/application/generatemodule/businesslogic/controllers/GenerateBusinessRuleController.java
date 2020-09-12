package org.application.generatemodule.businesslogic.controllers;

import org.application.domain.BusinessRule;
import org.application.generatemodule.businesslogic.services.GenerateBusinessRuleService;
import org.application.generatemodule.businesslogic.triggerGenerators.*;
import org.application.generatemodule.persistence.PostgresImpl.TriggerDaoPostgresImpl;

public class GenerateBusinessRuleController implements GenerateBusinessRuleService {

    //add services layers als bij define
    //private DaoProvider daoProvider = new DaoImplProvider();
    private TriggerDaoPostgresImpl triggerDaoPostgres;

    @Override
    public String generate(BusinessRule businessRule) {
        String templateCode = null;

        if (businessRule.getBusinessRuleType().getName().equals("ACMP")) {
            ACMPGenerator acmpGenerator = new ACMPGenerator();
            templateCode = acmpGenerator.generateTrigger(businessRule);
        } if (businessRule.getBusinessRuleType().getName().equals("TCMP")) {
            TCMPGenerator tcmpGenerator = new TCMPGenerator();
            templateCode = tcmpGenerator.generateTrigger(businessRule);
        } if (businessRule.getBusinessRuleType().getName().equals("ARNG")) {
            ARNGGenerator arngGenerator = new ARNGGenerator();
            templateCode = arngGenerator.generateTrigger(businessRule);
        } if (businessRule.getBusinessRuleType().getName().equals("ICMP")) {
            ICMPGenerator icmpGenerator = new ICMPGenerator();
            templateCode = icmpGenerator.generateTrigger(businessRule);
        }

        return templateCode;
    }

    @Override
    public void execute(String businessRuleCode) {
        triggerDaoPostgres.executeTrigger(businessRuleCode);
    }
}
