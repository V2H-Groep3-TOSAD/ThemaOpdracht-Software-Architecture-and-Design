package org.definemodule.persistence.PostgresImpl;

import org.domain.Table;
import org.definemodule.persistence.postgresdao.TableDao;

import javax.persistence.EntityManager;
import java.util.List;

public class TableDaoPostgresImpl extends AbstractDaoPostgresImpl<Table> implements TableDao {
    public TableDaoPostgresImpl(EntityManager entityManager){super(entityManager);};

    public List<Table> findByDatabaseId(int id){
        @SuppressWarnings("unchecked")
        List<Table> tables = (List<Table>) em
                .createQuery("from Table where database_id=" + id).getResultList();
        if (!tables.isEmpty()) {
            return tables;
        }
        return null;
    }

}

