package org.application.definemodule.businesslogic.controllers;

import org.application.definemodule.businesslogic.services.postgresserviceimpl.*;
import org.application.definemodule.persistence.PostgresImpl.BusinessRuleDaoPostgresImpl;
import org.application.definemodule.persistence.PostgresImpl.DaoProvider;
import org.application.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
import org.application.domain.*;

import java.util.List;

public class DefineBusinessRuleController {
    private final OperatorPostgresService operatorPostgresService;
    private final TablePostgresService tablePostgresService;
    private final BusinessRulePostgresService businessRulePostgresService;
    private final BusinessRuleTypePostgresService businessRuleTypePostgresService;
    private final CategoryPostgresService categoryPostgresService;
    private final ColumnService columnService;
    private final DatabasePostgresService databasePostgresService;
    private final ValueDefinitionPostgresService valueDefinitionPostgresService;
    private final BusinessRuleTypeOperatorPostgresService businessRuleTypeOperatorPostgresService;

    // hardcoded for now
    private final DaoProvider daoProvider = new PostgresDaoImplProvider();


    private BusinessRuleBuilder businessRuleBuilder = new BusinessRuleBuilder();

    public DefineBusinessRuleController(){
        operatorPostgresService = new OperatorPostgresService();
        tablePostgresService = new TablePostgresService();
        businessRulePostgresService = new BusinessRulePostgresService();
        businessRuleTypePostgresService = new BusinessRuleTypePostgresService();
        categoryPostgresService = new CategoryPostgresService();
        columnService = new ColumnService(daoProvider.getColumnDao());
        databasePostgresService = new DatabasePostgresService();
        valueDefinitionPostgresService = new ValueDefinitionPostgresService();
        businessRuleTypeOperatorPostgresService = new BusinessRuleTypeOperatorPostgresService();

        BusinessRule.BusinessRuleBuilder ruleBuilder = BusinessRule.builder();

        // Voorbeeld
        ruleBuilder.name("")
                .description("")
                .build();
    }

    public List<Database> giveAllDatabases(){
        return postgresServiceProvider.getDatabasePostgresService().getAllDatabases();
    }

    public List<Table> giveAllTablesByDatabase(Database database){
        return postgresServiceProvider.getTablePostgresService().getTablesByDatabaseId(database.getId());
    }

    public List<Column> giveAllColumnsByTable(Table table){
        return postgresServiceProvider.getColumnPostgresService().getColumnsByTableID(table.getId());
    }

    public List<Category> giveAllCategories(){
        return postgresServiceProvider.getCategoryPostgresService().getAllCategorys();
    }

    public List<BusinessRuleType> giveAllBusinessRuleTypes(){
        return postgresServiceProvider.getBusinessRuleTypePostgresService().getAllBusinessRuleTypes();
    }

    public List<BusinessRule> giveAllBusinessRules(){
        return postgresServiceProvider.getBusinessRulePostgresService().getAllBusinessRules();
    }

    public List<Operator> giveAllOperators(){
       return postgresServiceProvider.getOperatorPostgresService().getAllOperators();
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


}
