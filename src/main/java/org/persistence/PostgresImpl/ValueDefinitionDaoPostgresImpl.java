package org.persistence.PostgresImpl;

import org.domain.ValueDefinition;
import org.persistence.ValueDefinitionDao;

import javax.persistence.EntityManager;

public class ValueDefinitionDaoPostgresImpl extends AbstractDaoPostgresImpl<ValueDefinition> implements ValueDefinitionDao {
    public ValueDefinitionDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
