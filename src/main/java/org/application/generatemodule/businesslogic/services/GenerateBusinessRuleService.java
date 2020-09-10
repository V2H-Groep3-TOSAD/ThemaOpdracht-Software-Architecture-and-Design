package org.application.generatemodule.businesslogic.services;


import org.application.domain.BusinessRule;

public interface GenerateBusinessRuleService {

    public String generate(BusinessRule businessRule);
    public void execute(String businessRuleCode);
}
