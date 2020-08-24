package org.generatemodule.businesslogic.services;

import org.generatemodule.businesslogic.domain.BusinessRule;

import java.util.List;

public interface GenerateBusinessRuleService {

    public List<BusinessRule> giveAllBusinessRules();
    public String generate(BusinessRule businessRule);
    public void execute(String businessRuleCode);
}
