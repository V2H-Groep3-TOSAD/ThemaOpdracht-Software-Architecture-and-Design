package org.presentation;

import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.definemodule.persistence.postgresdao.HibernateUtil;
import org.domain.BusinessRule;
import org.domain.Column;
import org.domain.Operator;
import org.definemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.domain.Database;
import org.domain.Operator;
import org.generatemodule.businesslogic.controllers.GenerateBusinessRuleController;
import org.generatemodule.businesslogic.services.GenerateBusinessRuleService;
import org.generatemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
import org.generatemodule.persistence.PostgresImpl.TriggerDaoPostgresImpl;

import javax.persistence.EntityManager;
<<<<<<< Updated upstream
=======
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
>>>>>>> Stashed changes
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

        PostgresDaoImplProvider postgresDaoImplProvider = new PostgresDaoImplProvider();


        for (BusinessRule businessRule : businessRules) {
            System.out.println(businessRule.getColumns());
        }

<<<<<<< Updated upstream
        TriggerDaoPostgresImpl tdao = postgresDaoImplProvider.getTriggerDao();
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
=======

        String triggerQuery = generateBusinessRuleController.generate(businessRules.get(0));

        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        org.generatemodule.businesslogic.services.postgresservice.PostgresServiceProvider postgresServiceProviderTarget = new org.generatemodule.businesslogic.services.postgresservice.PostgresServiceProvider();
        postgresServiceProviderTarget.getPersonPostgresService().executeTrigger(triggerQuery);
        entityManager.getTransaction().commit();


        List list = new ArrayList();


        // int id, String postal, int housenr, int rent, int deposit, Person person


        Person person = new Person(999, "Sanne", 54);

        Address address = new Address(99, "HG8934", 143, 800, 500, person);

        Database database = new Database("hallo");
        //postgresServiceProvider.getDatabasePostgresService().saveOrUpdate(database);

        //WentityManager.persist(database);


        //postgresServiceProviderTarget.getAddressPostgresService().saveOrUpdate(address);
        //postgresServiceProviderTarget.getPersonPostgresService().saveOrUpdate(person);


//        String query = "INSERT INTO person VALUES (999, 'Sanne')";
//        postgresServiceProviderTarget.getPersonPostgresService().executeTrigger(query);

>>>>>>> Stashed changes




    }

}
