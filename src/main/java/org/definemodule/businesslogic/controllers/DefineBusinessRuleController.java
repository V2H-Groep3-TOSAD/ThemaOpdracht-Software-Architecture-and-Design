package org.definemodule.businesslogic.controllers;

import org.definemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.domain.*;

import java.util.List;

public class DefineBusinessRuleController {
    private PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();
    private BusinessRuleBuilder businessRuleBuilder = new BusinessRuleBuilder();

    public DefineBusinessRuleController(){ }

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

    public void setValueDefinition(ValueDefinition valueDefinition){
        businessRuleBuilder.setValueDefinition(valueDefinition);
    }

    public void setName(String name){
        businessRuleBuilder.setName(name);
    }

    public BusinessRule buildBusinessRule(){
       return businessRuleBuilder.build();
    }


}
