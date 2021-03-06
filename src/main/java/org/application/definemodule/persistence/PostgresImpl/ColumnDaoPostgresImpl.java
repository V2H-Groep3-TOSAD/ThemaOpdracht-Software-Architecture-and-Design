package org.application.definemodule.persistence.PostgresImpl;

import org.application.domain.Column;
import org.application.definemodule.persistence.postgresdao.ColumnDao;

import javax.persistence.EntityManager;
import java.util.List;

public class ColumnDaoPostgresImpl extends AbstractDaoPostgresImpl<Column> implements ColumnDao {
    public ColumnDaoPostgresImpl(EntityManager entityManager){super(entityManager);}

    public List<Column> findByTableId(int id){
        @SuppressWarnings("unchecked")
        List<Column> Columns = (List<Column>) em
                .createQuery("from Column where table_id=" + id).getResultList();
        if (!Columns.isEmpty()) {
            return Columns;
        }
        return null;
    }

    //todo findbydatatype
}
