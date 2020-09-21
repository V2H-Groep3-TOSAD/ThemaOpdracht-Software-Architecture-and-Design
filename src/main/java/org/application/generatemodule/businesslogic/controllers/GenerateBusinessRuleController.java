package org.application.generatemodule.businesslogic.controllers;

import org.application.domain.BusinessRule;
import org.application.generatemodule.businesslogic.services.GenerateBusinessRuleService;
import org.application.generatemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
import org.application.generatemodule.persistence.PostgresImpl.TriggerDaoPostgresImpl;
import org.application.generatemodule.businesslogic.triggerGenerators.GeneratorFacade;

public class GenerateBusinessRuleController implements GenerateBusinessRuleService {

    //add services layers als bij define
    //private DaoProvider daoProvider = new DaoImplProvider();
    private final PostgresDaoImplProvider daoProvider = new PostgresDaoImplProvider();
    private TriggerDaoPostgresImpl triggerDaoPostgres = daoProvider.getTriggerDao();

    @Override
    public String generate(BusinessRule businessRule) {
        GeneratorFacade generatorFacade = new GeneratorFacade();
        String queryCode = generatorFacade.generateQueryTemplate(businessRule);

        return queryCode;
    }

    @Override
    public void execute(String businessRuleCode) {
        triggerDaoPostgres.executeTrigger(businessRuleCode);
    }
}
