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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){
        PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();

        GenerateBusinessRuleController generateBusinessRuleController = new GenerateBusinessRuleController();
        DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();


        //List<BusinessRule> businessRules = postgresServiceProvider.getBusinessRulePostgresService().getAllBusinessRules();


        BusinessRule businessRuleAdd = postgresServiceProvider.getBusinessRulePostgresService().getBusinessRuleById(3);
        Column column2 = postgresServiceProvider.getColumnPostgresService().getColumnById(5);
        businessRuleAdd.getColumns().add(column2);
        postgresServiceProvider.getBusinessRulePostgresService().saveOrUpdate(businessRuleAdd);
        List<BusinessRule> businessRules = defineBusinessRuleController.giveAllBusinessRules();

        //PostgresDaoImplProvider postgresDaoImplProvider = new PostgresDaoImplProvider();


        for (BusinessRule businessRule : businessRules) {
            System.out.println(businessRule.getColumns());
        }


        String triggerQuery = generateBusinessRuleController.generate(businessRules.get(0));

        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactoryTarget();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        org.generatemodule.businesslogic.services.postgresservice.PostgresServiceProvider postgresServiceProviderTarget = new org.generatemodule.businesslogic.services.postgresservice.PostgresServiceProvider();
        postgresServiceProviderTarget.getPersonPostgresService().executeTrigger(triggerQuery);
        entityManager.getTransaction().commit();


        //List list = new ArrayList();


        // int id, String postal, int housenr, int rent, int deposit, Person person


        Person person = new Person("Sanne", 54);
        Address address = new Address("HG8934", 143, 800, 500, person);

        //Database database = new Database("hallo");

        postgresServiceProviderTarget.getPersonPostgresService().saveOrUpdate(person);
        postgresServiceProviderTarget.getAddressPostgresService().saveOrUpdate(address);


        //postgresServiceProvider.getDatabasePostgresService().saveOrUpdate(database);

        //WentityManager.persist(database);


        //postgresServiceProviderTarget.getAddressPostgresService().saveOrUpdate(address);
        //postgresServiceProviderTarget.getPersonPostgresService().saveOrUpdate(person);


//        String query = "INSERT INTO person VALUES (999, 'Sanne')";
//        postgresServiceProviderTarget.getPersonPostgresService().executeTrigger(query);





    }

}
