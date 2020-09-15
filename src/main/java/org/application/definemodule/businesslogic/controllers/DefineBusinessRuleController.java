package org.application.definemodule.businesslogic.controllers;

import org.application.definemodule.businesslogic.services.*;

import org.application.definemodule.persistence.PostgresImpl.DaoProvider;
import org.application.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
import org.application.domain.*;
import org.application.domain.Column;
import org.application.domain.Table;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;

public class DefineBusinessRuleController {
    private final OperatorService operatorService;
    private final TableService tableService;
    private final BusinessRuleService businessRuleService;
    private final BusinessRuleTypeService businessRuleTypeService;
    private final CategoryService categoryService;
    private final ColumnService columnService;
    private final DatabaseService databaseService;
    private final ValueDefinitionService valueDefinitionService;
    private final BusinessRuleTypeOperatorService businessRuleTypeOperatorService;

    private final DaoProvider daoProvider = new PostgresDaoImplProvider();
    private final BusinessRule.BusinessRuleBuilder businessRuleBuilder;

    public DefineBusinessRuleController(){
        operatorService = new OperatorService(daoProvider.getOperatorDao());
        tableService = new TableService(daoProvider.getTableDao());
        businessRuleService = new BusinessRuleService(daoProvider.getBusinessRuleDao());
        businessRuleTypeService = new BusinessRuleTypeService(daoProvider.getBusinessRuleTypeDao());
        categoryService = new CategoryService(daoProvider.getCategoryDao());
        columnService = new ColumnService(daoProvider.getColumnDao());
        databaseService = new DatabaseService(daoProvider.getDatabaseDao());
        valueDefinitionService = new ValueDefinitionService(daoProvider.getValueDefinitionDao());
        businessRuleTypeOperatorService = new BusinessRuleTypeOperatorService(daoProvider.getBusinessRuleTypeOperatorDao());

        this.businessRuleBuilder  = BusinessRule.builder();
    }

    public List<Database> giveAllDatabases(){
        return databaseService.getAllDatabases();
    }

    public List<Table> giveAllTablesByDatabase(Database database){
        return tableService.getTablesByDatabaseId(database.getId());
    }

    public List<Column> giveAllColumnsByTable(Table table){
        return columnService.getColumnsByTableID(table.getId());
    }

    public List<Category> giveAllCategories(){
        //return categoryService.getAll();
        return categoryService.getAllCategorys();
    }

    public List<BusinessRuleType> giveAllBusinessRuleTypes(){
        return businessRuleTypeService.getAllBusinessRuleTypes();
        //return businessRuleTypeService.getAll();
    }

    public List<BusinessRuleTypeOperator> giveAllOperatorsByBusinessRuleType(BusinessRuleType businessRuleType){
        return businessRuleTypeOperatorService.getBusinessRuleTypeOperators(businessRuleType);
    }

    public List<BusinessRule> giveAllBusinessRules(){
        return businessRuleService.getAllBusinessRules();
        //return businessRuleService.getAll();
    }

    public List<Operator> giveAllOperators(){

        return operatorService.getAllOperators();
        //return operatorService.getAll();
    }

    public void setBusinessRuleType(BusinessRuleType businessRuleType){
        businessRuleBuilder.businessRuleType(businessRuleType);
    }

    public void setOperator(Operator operator){

        businessRuleBuilder.operator(operator);
    }

    public void setTables(List<Table> allTables){
        businessRuleBuilder.setTable(allTables);
    }

    public void setValueDefinition(ValueDefinition valueDefinition){
        businessRuleBuilder.valueDefinition(valueDefinition);
    }

    public void setDatabase(Database database){
        businessRuleBuilder.setDatabase(database);
    }

    public void generateBusinessRuleName(){
        //todo input applicatie name
        //todo volgnummer
        String name = "BRG_APPNAME_" +  businessRuleBuilder.getTables().indexOf(0) + "_CNS_"
                + businessRuleBuilder.getBusinessRuleType().getName() + "_1";
        businessRuleBuilder.name(name);
        businessRuleBuilder.description(name);
    }
    public void setName(String name){
        businessRuleBuilder.name(name);
    }

    public BusinessRule buildBusinessRule(){
       return businessRuleBuilder.build();
    }

    public BusinessRule.BusinessRuleBuilder getBusinessRuleBuilder() {
        return this.businessRuleBuilder;

    }

    public BusinessRuleType geBusinessRuleType(){
        return businessRuleBuilder.getBusinessRuleType();
    }

    public void saveBusinessRule(BusinessRule businessRule){

        businessRuleService.saveOrUpdate(businessRule);
    }

    public List<ValueDefinition> getValueDefinitions(){
        return valueDefinitionService.getAllValueDefinitions();
    }

    public void saveValueDef(ValueDefinition valueDefinition){
        valueDefinitionService.saveOrUpdate(valueDefinition);
    }

    public ValueDefinition findValueDefinition(ValueDefinition valueDefinition){
        List<ValueDefinition> allValueDefinitions = getValueDefinitions();
        System.out.println(allValueDefinitions);
        for (ValueDefinition valueDefinition1 : allValueDefinitions){
            if(valueDefinition1.equals(valueDefinition)){
                return valueDefinition1;
            }
        }
        return null;
    }

//    public List<ValueDefinition> findValueDefinitionByValue(ValueDefinition valueDefinition){
//        return valueDefinitionService.getValueDefinitionsByValue(valueDefinition);
////        List<ValueDefinition> allValueDefinitions = valueDefinitionService.getValueDefinitionsByValue(valueDefinition);
////        System.out.println(allValueDefinitions);
////        for (ValueDefinition valueDefinition1 : allValueDefinitions){
////            if(valueDefinition1.equals(valueDefinition)){
////                return valueDefinition1;
////            }
////        }
////        return null;
//    }


    public void setColumns(List<Column> allColumns){
        businessRuleBuilder.setColumns(allColumns);
    }

    public List<Column> getColumns(){
        return businessRuleBuilder.getColumns();
    }

}
