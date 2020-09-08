package org.presentation;

import org.domain.BusinessRule;
import org.domain.Column;
import org.domain.Operator;
import org.definemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.generatemodule.businesslogic.controllers.GenerateBusinessRuleController;
import org.generatemodule.businesslogic.services.GenerateBusinessRuleService;
import org.generatemodule.businesslogic.targetdomain.Address;
import org.generatemodule.businesslogic.targetdomain.Person;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();

        GenerateBusinessRuleController generateBusinessRuleController = new GenerateBusinessRuleController();

        List<BusinessRule> businessRules = postgresServiceProvider.getBusinessRulePostgresService().getAllBusinessRules();

        for (BusinessRule businessRule : businessRules){

            System.out.println("----------------------------");
            System.out.println(businessRule.getName());
//            System.out.println(businessRule.getColumns().get(0).getName());

            for (Column column : businessRule.getColumns()) {
                System.out.println(column.toString());
            }

            System.out.println("");
            System.out.println(generateBusinessRuleController.generate(businessRule));
            System.out.println("----------------------------");
        }

        String triggerQuery = generateBusinessRuleController.generate(businessRules.get(0));

        org.generatemodule.businesslogic.services.postgresservice.PostgresServiceProvider postgresServiceProviderTarget = new org.generatemodule.businesslogic.services.postgresservice.PostgresServiceProvider();

        List list = new ArrayList();


        // int id, String postal, int housenr, int rent, int deposit, Person person


        Person person = new Person(999, "Sanne", 54);

        Address address = new Address(99, "HG8934", 143, 800, 500, person);

        postgresServiceProviderTarget.getAddressPostgresService().saveOrUpdate(address);


//        String query = "INSERT INTO person VALUES (999, 'Sanne')";
//        postgresServiceProviderTarget.getPersonPostgresService().executeTrigger(query);



    }

}
