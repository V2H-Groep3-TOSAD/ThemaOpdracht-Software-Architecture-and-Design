package org.generatemodule.businesslogic.controllers;

import org.domain.BusinessRule;
import org.generatemodule.businesslogic.services.GenerateBusinessRuleService;
import org.generatemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.generatemodule.businesslogic.triggerGenerators.*;
import org.generatemodule.persistence.PostgresImpl.PostgresDaoImplProvider;

import java.util.List;

public class GenerateBusinessRuleController implements GenerateBusinessRuleService {

    private PostgresDaoImplProvider postgresDaoImplProvider = new PostgresDaoImplProvider();

    @Override
    public String generate(BusinessRule businessRule) {
        GeneratorFacade generatorFacade = new GeneratorFacade();
        String queryCode = generatorFacade.generateQueryTemplate(businessRule);

        return queryCode;
    }

    @Override
    public void execute(String businessRuleCode) {
        postgresDaoImplProvider.getTriggerDao().executeTrigger(businessRuleCode);

    }
}
