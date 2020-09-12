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

    // hardcoded for now
    private final DaoProvider daoProvider = new PostgresDaoImplProvider();
    private BusinessRuleBuilder businessRuleBuilder = new BusinessRuleBuilder();

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

        BusinessRule.BusinessRuleBuilder ruleBuilder = BusinessRule.builder();

        // Voorbeeld
        ruleBuilder.name("")
                .description("")
                .build();
    }

    public List<Database> giveAllDatabases(){
        //return databaseService.getAll();
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
        businessRuleBuilder.setBusinessRuleType(businessRuleType);
    }

    public void setOperator(Operator operator){
        businessRuleBuilder.setOperator(operator);
    }

    public void setTable(Table table){
        businessRuleBuilder.setTable(table);
    }

    public void setValueDefinition(ValueDefinition valueDefinition){
        businessRuleBuilder.setValueDefinition(valueDefinition);
    }

    public void generateBusinessRuleName(){
        //input applicatie name
        //volgnummer
        String name = "BRG_APPNAME_" +  businessRuleBuilder.getTable().getName() + "_CNS_"
                + businessRuleBuilder.getBusinessRuleType().getName() + "_1";
        setName(name);
    }
    public void setName(String name){
        businessRuleBuilder.setName(name);
    }

    public BusinessRule buildBusinessRule(){
       return businessRuleBuilder.build();
    }

    public BusinessRuleBuilder getBusinessRuleBuilder() {
        return businessRuleBuilder;
    }

    public BusinessRuleType geBusinessRuleType(){
        return businessRuleBuilder.getBusinessRuleType();
    }

    public void saveBusinessRule(BusinessRule businessRule){
        businessRuleService.saveOrUpdate(businessRule);
    }


}
