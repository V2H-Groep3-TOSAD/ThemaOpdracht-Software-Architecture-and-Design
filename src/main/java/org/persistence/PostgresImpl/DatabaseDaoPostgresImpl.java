package org.persistence.PostgresImpl;

import org.domain.Database;
import org.persistence.DatabaseDao;

import javax.persistence.EntityManager;

public class DatabaseDaoPostgresImpl extends AbstractDaoPostgresImpl<Database> implements DatabaseDao {
    public DatabaseDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
