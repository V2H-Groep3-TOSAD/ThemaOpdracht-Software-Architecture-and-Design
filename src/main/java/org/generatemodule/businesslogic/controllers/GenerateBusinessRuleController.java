package org.generatemodule.businesslogic.controllers;

import org.domain.BusinessRule;
import org.generatemodule.businesslogic.services.GenerateBusinessRuleService;
import org.generatemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.generatemodule.businesslogic.triggerGenerators.*;
import org.generatemodule.persistence.PostgresImpl.PostgresDaoImplProvider;

import java.util.List;

public class GenerateBusinessRuleController implements GenerateBusinessRuleService {

    private PostgresDaoImplProvider postgresDaoImplProvider = new PostgresDaoImplProvider();

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
        postgresDaoImplProvider.getTriggerDao().executeTrigger(businessRuleCode);

    }
}
