package org.generatemodule.persistence.PostgresImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class TriggerDaoPostgresImpl {
    private EntityManager entityManager;

    public TriggerDaoPostgresImpl(EntityManager em){
        entityManager = em;
    }

    public void executeTrigger (String triggerQuery) {

       
        entityManager.createNativeQuery(triggerQuery);
    }


}
