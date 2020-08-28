package org.definemodule.persistence.postgresdaoimpl;

import org.domain.Database;
import org.definemodule.persistence.postgresdao.DatabaseDao;

import javax.persistence.EntityManager;

public class DatabaseDaoPostgresImpl extends AbstractDaoPostgresImpl<Database> implements DatabaseDao {
    public DatabaseDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
