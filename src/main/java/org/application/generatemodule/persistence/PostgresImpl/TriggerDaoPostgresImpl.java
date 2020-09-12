package org.application.generatemodule.persistence.PostgresImpl;

import javax.persistence.EntityManager;

public class TriggerDaoPostgresImpl {
    private EntityManager entityManager;

    public TriggerDaoPostgresImpl(EntityManager em){
        entityManager = em;
    }

    public void executeTrigger (String triggerQuery) {

        entityManager.getTransaction().begin();
        entityManager.createNativeQuery(triggerQuery).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
