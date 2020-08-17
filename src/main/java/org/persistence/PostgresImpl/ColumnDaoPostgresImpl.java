package org.persistence.PostgresImpl;

import org.domain.Column;
import org.persistence.ColumnDao;

import javax.persistence.EntityManager;

public class ColumnDaoPostgresImpl extends AbstractDaoPostgresImpl<Column> implements ColumnDao {
    public ColumnDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
