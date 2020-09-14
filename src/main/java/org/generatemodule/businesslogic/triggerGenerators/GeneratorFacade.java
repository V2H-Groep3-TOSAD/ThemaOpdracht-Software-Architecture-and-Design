package org.generatemodule.businesslogic.triggerGenerators;

import org.domain.BusinessRule;

public class GeneratorFacade {

    public String generateQueryTemplate (BusinessRule businessRule) {
        String queryCode = null;

        if (businessRule.getBusinessRuleType().getName().equals("ACMP")) {
            ACMPGenerator acmpGenerator = new ACMPGenerator();
            queryCode = acmpGenerator.generateTrigger(businessRule);
        } if (businessRule.getBusinessRuleType().getName().equals("TCMP")) {
            TCMPGenerator tcmpGenerator = new TCMPGenerator();
            queryCode = tcmpGenerator.generateTrigger(businessRule);
        } if (businessRule.getBusinessRuleType().getName().equals("ARNG")) {
            ARNGGenerator arngGenerator = new ARNGGenerator();
            queryCode = arngGenerator.generateTrigger(businessRule);
        } if (businessRule.getBusinessRuleType().getName().equals("ICMP")) {
            ICMPGenerator icmpGenerator = new ICMPGenerator();
            queryCode = icmpGenerator.generateTrigger(businessRule);
        } else {
            System.out.println("Geen geldige Businessruletype");
        }

        return queryCode;

    }

}
