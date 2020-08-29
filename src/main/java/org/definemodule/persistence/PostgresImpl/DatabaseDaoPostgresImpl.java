package org.definemodule.persistence.PostgresImpl;

import org.domain.Database;
import org.definemodule.persistence.postgresdao.DatabaseDao;

import javax.persistence.EntityManager;
import java.util.List;

public class DatabaseDaoPostgresImpl extends AbstractDaoPostgresImpl<Database> implements DatabaseDao {
    public DatabaseDaoPostgresImpl(EntityManager entityManager){super(entityManager);}

    public List<Database> findByName( String code){
        @SuppressWarnings("unchecked")
        List<Database> databases = (List<Database>)  em.createQuery("From Database where code=" + code).getResultList();
               // em.createQuery("From Database where name=" + name).getResultList();
        if (!databases.isEmpty()) {
            System.out.println(databases);
            return databases;
        }
        return null;


    }
}
