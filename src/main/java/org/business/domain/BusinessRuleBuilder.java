package org.business.domain;

public class BusinessRuleBuilder {

    private String name;
    private String description;
    private int volgNummer;
    private BusinessRuleType businessRuleType;
    private Operator operator;
    private ValueDefinition valueDefinition;


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVolgNummer(int volgNummer) {
        this.volgNummer = volgNummer;
    }

    public void setBusinessRuleType(BusinessRuleType businessRuleType) {
        this.businessRuleType = businessRuleType;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setValueDefinition(ValueDefinition valueDefinition) {
        this.valueDefinition = valueDefinition;
    }

    public BusinessRule build(){
        return new BusinessRule(this.name, this.description, this.volgNummer, this.businessRuleType, this.operator, this.valueDefinition);
    }

}
