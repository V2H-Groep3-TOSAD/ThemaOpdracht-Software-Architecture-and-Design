package org.persistence.PostgresImpl;

import org.business.domain.tool.Operator;
import org.persistence.OperatorDao;

import javax.persistence.EntityManager;
import java.util.List;

public class OperatorDaoPostgresImpl extends AbstractDaoPostgresImpl<Operator> implements OperatorDao {

    public OperatorDaoPostgresImpl(EntityManager entityManager){
        super(entityManager);
    }

    @Override
    public List<Operator> findByName(String name){
        @SuppressWarnings("unchecked")
        List<Operator> operators = (List<Operator>) em
                .createQuery("from Operator where name=" + name).getResultList();
        if (!operators.isEmpty()) {
            System.out.println(operators);
            return operators;
        }
        return null;
    }
}
