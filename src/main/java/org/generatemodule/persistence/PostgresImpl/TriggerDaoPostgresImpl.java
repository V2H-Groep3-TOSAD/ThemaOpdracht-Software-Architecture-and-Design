package org.generatemodule.persistence.PostgresImpl;

import org.definemodule.persistence.postgresdao.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TriggerDaoPostgresImpl {
    private EntityManager entityManager;

    public TriggerDaoPostgresImpl(EntityManager em){
        entityManager = em;
    }

    public void executeTrigger (String triggerQuery) {

        entityManager.getTransaction().begin();
        entityManager.createNativeQuery(triggerQuery);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
