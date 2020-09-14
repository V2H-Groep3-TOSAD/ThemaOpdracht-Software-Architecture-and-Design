package org.domain;

import java.util.List;

public class BusinessRuleBuilder {

    private String name;
    private String description;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getVolgNummer() {
        return volgNummer;
    }

    public Operator getOperator() {
        return operator;
    }

    public ValueDefinition getValueDefinition() {
        return valueDefinition;
    }

    private int volgNummer;
    private BusinessRuleType businessRuleType;
    private Operator operator;
    private ValueDefinition valueDefinition;

    public List<Table> getTable() {
        return table;
    }

    public void setTable(List<Table> table) {
        this.table = table;
    }

    private List<Table> table;

    public List<Column> getAllColumns() {
        return allColumns;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    private Database database;

    public void setAllColumns(List<Column> allColumns) {
        this.allColumns = allColumns;
    }

    private List<Column> allColumns;


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

    public BusinessRuleType getBusinessRuleType() {
        return businessRuleType;
    }
}
