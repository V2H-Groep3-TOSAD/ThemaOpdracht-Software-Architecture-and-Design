package org.persistence.PostgresImpl;

import org.domain.Table;
import org.persistence.PostgresImpl.AbstractDaoPostgresImpl;
import org.persistence.TableDao;

import javax.persistence.EntityManager;

public class TableDaoPostgresImpl extends AbstractDaoPostgresImpl<Table> implements TableDao {
    public TableDaoPostgresImpl(EntityManager entityManager){super(entityManager);};

}

