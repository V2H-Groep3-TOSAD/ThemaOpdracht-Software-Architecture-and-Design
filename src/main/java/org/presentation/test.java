package org.presentation;



import org.application.definemodule.businesslogic.controllers.DefineBusinessRuleController;

import org.application.domain.BusinessRule;
import org.application.generatemodule.businesslogic.controllers.GenerateBusinessRuleController;
import org.application.generatemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
import org.application.generatemodule.persistence.PostgresImpl.TriggerDaoPostgresImpl;

import javax.persistence.EntityManager;
import java.util.List;

public class test {
    public static void main(String[] args){

        GenerateBusinessRuleController generateBusinessRuleController = new GenerateBusinessRuleController();


        List<BusinessRule> businessRules = defineBusinessRuleController.giveAllBusinessRules();

        for (BusinessRule businessRule : businessRules) {

            String triggerQuery = generateBusinessRuleController.generate(businessRule);

            System.out.println(triggerQuery);

            PostgresDaoImplProvider postgresDaoImplProvider = new PostgresDaoImplProvider();
            postgresDaoImplProvider.getTriggerDao().executeTrigger(triggerQuery);
        }



//        String triggerQuery = generateBusinessRuleController.generate(businessRules.get(0));
//
//        System.out.println(triggerQuery);

//        PostgresDaoImplProvider postgresDaoImplProvider = new PostgresDaoImplProvider();
//        postgresDaoImplProvider.getTriggerDao().executeTrigger(triggerQuery);


    }

}
