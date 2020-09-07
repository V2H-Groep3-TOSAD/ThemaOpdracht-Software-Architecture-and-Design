package org.presentation;

import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.BusinessRule;
import org.domain.Column;
import org.domain.Operator;
import org.definemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.generatemodule.businesslogic.controllers.GenerateBusinessRuleController;
import org.generatemodule.businesslogic.services.GenerateBusinessRuleService;

import java.util.List;

public class test {
    public static void main(String[] args){
        PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();

        GenerateBusinessRuleController generateBusinessRuleController = new GenerateBusinessRuleController();
        DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();


        //List<BusinessRule> businessRules = postgresServiceProvider.getBusinessRulePostgresService().getAllBusinessRules();


        BusinessRule businessRuleAdd = postgresServiceProvider.getBusinessRulePostgresService().getBusinessRuleById(3);
        Column column2 = postgresServiceProvider.getColumnPostgresService().getColumnById(5);
        businessRuleAdd.addColumn(column2);
        column2.addBusinessRules(businessRuleAdd);
        postgresServiceProvider.getColumnPostgresService().saveOrUpdate(column2);
        List<BusinessRule> businessRules = defineBusinessRuleController.giveAllBusinessRules();


        for (BusinessRule businessRule : businessRules) {
            System.out.println(businessRule.getColumns());
        }
//
//
//
//            System.out.println("----------------------------");
//            System.out.println(businessRule.getName());
////            System.out.println(businessRule.getColumns().get(0).getName());
//
//            for (Column column : businessRule.getColumns()) {
//                System.out.println(column.toString());
//            }
//
//            System.out.println("");
//            //System.out.println(generateBusinessRuleController.generate(businessRule));
//            System.out.println("----------------------------");
//        }
//


    }

}
