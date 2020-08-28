package org.persistence.PostgresImpl;

import org.business.domain.tool.Table;
import org.persistence.TableDao;

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

