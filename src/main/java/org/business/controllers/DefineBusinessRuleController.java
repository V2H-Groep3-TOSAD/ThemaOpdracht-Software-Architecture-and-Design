package org.business.controllers;

import org.business.domain.BusinessRule;
import org.business.domain.BusinessRuleBuilder;
import org.business.domain.Database;
import org.business.domain.Table;
import org.services.PostgresServiceProvider;

import java.util.List;

public class DefineBusinessRuleController {
    private PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();
    private BusinessRuleBuilder businessRuleBuilder = new BusinessRuleBuilder();

    public DefineBusinessRuleController(){

    }

    public List<Database> giveAllDatabases(){
        return postgresServiceProvider.getDatabasePostgresService().getAllDatabases();
    }

    public List<Table> giveAllTablesByDatabase(Database database){
        return postgresServiceProvider.getTablePostgresService().);
    }
}
