package org.openjfx;

import org.domain.Operator;
import org.definemodule.businesslogic.services.postgresservice.PostgresServiceProvider;

import java.util.List;

public class test {
    public static void main(String[] args){
        PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();
        List<Operator> operators = postgresServiceProvider.getOperatorPostgresService().getAllOperators();
        for (Operator operator : operators){
            System.out.println(operator.getName());
        }
        System.out.println(postgresServiceProvider.getOperatorPostgresService().getOperatorById(1));;
//        System.out.println(postgresServiceProvider.getBusinessRulePostgresService().getById(1));

    }

}
