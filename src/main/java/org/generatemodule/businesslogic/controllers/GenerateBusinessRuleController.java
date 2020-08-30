package org.generatemodule.businesslogic.controllers;

import org.domain.BusinessRule;
import org.generatemodule.businesslogic.services.GenerateBusinessRuleService;
import org.generatemodule.businesslogic.services.triggerGenerators.*;

import java.util.List;

public class GenerateBusinessRuleController implements GenerateBusinessRuleService {
    @Override
    public List<BusinessRule> giveAllBusinessRules() {
        return null;
    }

    @Override
    public String generate(BusinessRule businessRule) {
        String templateCode = null;
        if(businessRule.getBusinessRuleType().getName().equals("Attribute Range Rule") && businessRule.getOperator().getName().equals("Betweem")){
            attributeRangeBetween arb = new attributeRangeBetween();
            templateCode = arb.generateTrigger(businessRule);
        }
        if(businessRule.getBusinessRuleType().getName().equals("Attribute Range Rule") && businessRule.getOperator().getName().equals("Not Betweem")){
            attributeRangeNotBetween arnb = new attributeRangeNotBetween();
            templateCode = arnb.generateTrigger(businessRule);
        }
        if(businessRule.getBusinessRuleType().getName().equals("Attribute Compare Rule") && businessRule.getOperator().getName().equals("Equal")){
            attributeCompareEqual ace = new attributeCompareEqual();
            templateCode = ace.generateTrigger(businessRule);
        }
        if(businessRule.getBusinessRuleType().getName().equals("Attribute Compare Rule") && businessRule.getOperator().getName().equals("Not Equal")){
            attributeCompareNotEqual acne = new attributeCompareNotEqual();
            templateCode = acne.generateTrigger(businessRule);
        }
        if (businessRule.getBusinessRuleType().getName().equals("Attribute Compare Rule") && businessRule.getOperator().getName().equals("Greater")){
            attributeCompareGreater acg = new attributeCompareGreater();
            templateCode = acg.generateTrigger(businessRule);
        }
        if (businessRule.getBusinessRuleType().getName().equals("Attribute Compare Rule") && businessRule.getOperator().getName().equals("Smaller")){
            attributeCompareSmaller acs = new attributeCompareSmaller();
            templateCode = acs.generateTrigger(businessRule);
        }
        if (businessRule.getBusinessRuleType().getName().equals("Attribute Compare Rule") && businessRule.getOperator().getName().equals("Smaller Or Equal")){
            attributeCompareSmallerOrEqual acsoe = new attributeCompareSmallerOrEqual();
            templateCode = acsoe.generateTrigger(businessRule);
        }
        if (businessRule.getBusinessRuleType().getName().equals("Attribute Compare Rule") && businessRule.getOperator().getName().equals("Greater Or Equal")){
            attributeCompareGreaterOrEqual acgoe = new attributeCompareGreaterOrEqual();
            templateCode = acgoe.generateTrigger(businessRule);
        }

        return templateCode;
    }

    @Override
    public void execute(String businessRuleCode) {

    }
}
