package org.persistence.postgresdaoimpl;

import org.businesslogic.domain.Column;
import org.persistence.postgresdao.ColumnDao;

import javax.persistence.EntityManager;

public class ColumnDaoPostgresImpl extends AbstractDaoPostgresImpl<Column> implements ColumnDao {
    public ColumnDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
