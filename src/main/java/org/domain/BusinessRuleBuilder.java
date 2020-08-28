package org.domain;

import lombok.Setter;

@Setter
public class BusinessRuleBuilder {

    private String name;
    private String description;
    private BusinessRuleType businessRuleType;
    private Operator operator;
    private ValueDefinition valueDefinition;

    public BusinessRule build(){
        return new BusinessRule(this.name, this.description, this.businessRuleType, this.operator, this.valueDefinition);
    }

}
