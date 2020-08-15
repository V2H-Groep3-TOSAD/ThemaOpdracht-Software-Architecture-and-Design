package org.services.impl;

import org.domain.Operator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.services.HibernateUtil;
import org.services.OperatorService;

import java.util.ArrayList;
import java.util.List;

public class OperatorServiceImpl extends HibernateUtil implements OperatorService {

    @Override
    public void saveOrUpdate(Operator operator) {

    }

    @Override
    public Operator getOperatorByName(String name) {
        return null;
    }

    @Override
    public Operator getOperatorById(int id) {
        return null;
    }

    @Override
    public List<Operator> getAllOperators() {
        Operator u = null;
        List<Operator> alleOperators = new ArrayList<Operator>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List alleObjecten = session.createQuery("FROM Operator").list();
            for(Object o : alleObjecten) {
                if(o instanceof Operator) {
                    u = (Operator)o;
                    alleOperators.add(u);
                }
            }
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return alleOperators;

    }
}
