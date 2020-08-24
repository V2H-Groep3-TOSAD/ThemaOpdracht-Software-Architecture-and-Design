package org.persistence.postgresdaoimpl;

import org.businesslogic.domain.Table;
import org.persistence.postgresdao.TableDao;

import javax.persistence.EntityManager;

public class TableDaoPostgresImpl extends AbstractDaoPostgresImpl<Table> implements TableDao {
    public TableDaoPostgresImpl(EntityManager entityManager){super(entityManager);};

}

