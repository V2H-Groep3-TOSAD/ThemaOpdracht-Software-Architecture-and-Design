package org.persistence.postgresdaoimpl;

import org.businesslogic.domain.Database;
import org.persistence.postgresdao.DatabaseDao;

import javax.persistence.EntityManager;

public class DatabaseDaoPostgresImpl extends AbstractDaoPostgresImpl<Database> implements DatabaseDao {
    public DatabaseDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
