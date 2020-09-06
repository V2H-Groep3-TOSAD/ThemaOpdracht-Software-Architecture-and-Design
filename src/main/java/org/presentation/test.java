package org.presentation;

import org.domain.BusinessRule;
import org.domain.Operator;
import org.definemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.generatemodule.businesslogic.controllers.GenerateBusinessRuleController;
import org.generatemodule.businesslogic.services.GenerateBusinessRuleService;

import java.util.List;

public class test {
    public static void main(String[] args){
        PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();

        GenerateBusinessRuleController generateBusinessRuleController = new GenerateBusinessRuleController();

        List<BusinessRule> businessRules = postgresServiceProvider.getBusinessRulePostgresService().getAllBusinessRules();

        for (BusinessRule businessRule : businessRules){
            System.out.println(businessRule.getName());
            System.out.println(businessRule.getBusinessRuleType().getName());
            System.out.println(businessRule.getOperator().getName());

            System.out.println("----------------------------");
            System.out.println(generateBusinessRuleController.generate(businessRule));
            System.out.println("----------------------------");
        }



    }

}
