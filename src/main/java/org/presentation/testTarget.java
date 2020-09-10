package org.presentation;

import org.application.generatemodule.businesslogic.domain.Person;
import org.application.generatemodule.businesslogic.services.postgresservice.PostgresServiceProvider;

import java.util.List;

public class testTarget {
    public static void main(String[] args){
        PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();
        List<Person> persons = postgresServiceProvider.getPersonPostgresService().getAllPersons();

        for (Person person : persons){
            System.out.println(person.getName());
        }

        System.out.println(postgresServiceProvider.getPersonPostgresService().getPersonById(1));;
//        System.out.println(postgresServiceProvider.getBusinessRulePostgresService().getById(1));

    }

}
