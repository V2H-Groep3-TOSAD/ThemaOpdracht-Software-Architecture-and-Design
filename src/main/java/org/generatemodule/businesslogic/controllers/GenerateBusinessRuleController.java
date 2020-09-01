package org.generatemodule.businesslogic.controllers;

import org.domain.BusinessRule;
import org.generatemodule.businesslogic.services.GenerateBusinessRuleService;
import org.generatemodule.businesslogic.triggerGenerators.*;

import java.util.List;

public class GenerateBusinessRuleController implements GenerateBusinessRuleService {
    @Override
    public List<BusinessRule> giveAllBusinessRules() {
        return null;
    }

    @Override
    public String generate(BusinessRule businessRule) {
        String templateCode = null;

        if (businessRule.getBusinessRuleType().getName().equals("ACMP")) {
            ACMPGenerator acmpGenerator = new ACMPGenerator();
            templateCode = acmpGenerator.generateTrigger(businessRule);
        } if (businessRule.getBusinessRuleType().getName().equals("TCMP")) {
            ACMPGenerator acmpGenerator = new ACMPGenerator();
            templateCode = acmpGenerator.generateTrigger(businessRule);
        } if (businessRule.getBusinessRuleType().getName().equals("ARNG")) {
            ACMPGenerator acmpGenerator = new ACMPGenerator();
            templateCode = acmpGenerator.generateTrigger(businessRule);
        } if (businessRule.getBusinessRuleType().getName().equals("ICMP")) {
            ACMPGenerator acmpGenerator = new ACMPGenerator();
            templateCode = acmpGenerator.generateTrigger(businessRule);
        }


//        if(businessRule.getBusinessRuleType().getName().equals("Attribute Range Rule") && businessRule.getOperator().getName().equals("Between")){
//            attributeRangeBetween arb = new attributeRangeBetween();
//            templateCode = arb.generateTrigger(businessRule);
//        }
//        if(businessRule.getBusinessRuleType().getName().equals("Attribute Range Rule") && businessRule.getOperator().getName().equals("Not Between")){
//            attributeRangeNotBetween arnb = new attributeRangeNotBetween();
//            templateCode = arnb.generateTrigger(businessRule);
//        }


        return templateCode;
    }

    @Override
    public void execute(String businessRuleCode) {

    }
}
