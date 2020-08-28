package org.persistence.PostgresImpl;

import org.business.domain.tool.Database;
import org.persistence.DatabaseDao;

import javax.persistence.EntityManager;
import java.util.List;

public class DatabaseDaoPostgresImpl extends AbstractDaoPostgresImpl<Database> implements DatabaseDao {
    public DatabaseDaoPostgresImpl(EntityManager entityManager){super(entityManager);}

    public List<Database> findByName(String name){
        @SuppressWarnings("unchecked")
        List<Database> Databases = (List<Database>) em
                .createQuery("from Database where name=" + name).getResultList();
        if (!Databases.isEmpty()) {
            System.out.println(Databases);
            return Databases;
        }
        return null;
    }
}
