package org.persistence.PostgresImpl;

import org.business.domain.tool.Database;
import org.persistence.DatabaseDao;

import javax.persistence.EntityManager;

public class DatabaseDaoPostgresImpl extends AbstractDaoPostgresImpl<Database> implements DatabaseDao {
    public DatabaseDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
