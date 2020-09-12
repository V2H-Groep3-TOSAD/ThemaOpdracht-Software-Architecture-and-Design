package org.presentation;

import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.definemodule.persistence.postgresdao.HibernateUtil;
import org.domain.BusinessRule;
import org.domain.Column;
import org.definemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.domain.Database;
import org.domain.Operator;
import org.generatemodule.businesslogic.controllers.GenerateBusinessRuleController;
import org.generatemodule.businesslogic.domain.Address;
import org.generatemodule.businesslogic.domain.Person;
import org.generatemodule.persistence.PostgresImpl.PostgresDaoImplProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();

        GenerateBusinessRuleController generateBusinessRuleController = new GenerateBusinessRuleController();


        List<BusinessRule> businessRules = postgresServiceProvider.getBusinessRulePostgresService().getAllBusinessRules();

        for (BusinessRule businessRule : businessRules) {

            String triggerQuery = generateBusinessRuleController.generate(businessRule);

            System.out.println(triggerQuery);
        }


//        String triggerQuery = generateBusinessRuleController.generate(businessRules.get(2));
//
//        System.out.println(triggerQuery);

//        PostgresDaoImplProvider postgresDaoImplProvider = new PostgresDaoImplProvider();
//        postgresDaoImplProvider.getTriggerDao().executeTrigger(triggerQuery);


    }

}
