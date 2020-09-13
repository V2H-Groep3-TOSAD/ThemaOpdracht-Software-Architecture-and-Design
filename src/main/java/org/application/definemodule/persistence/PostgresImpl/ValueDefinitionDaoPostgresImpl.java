package org.application.definemodule.persistence.PostgresImpl;

import org.application.domain.ValueDefinition;
import org.application.definemodule.persistence.postgresdao.ValueDefinitionDao;

import javax.persistence.EntityManager;

public class ValueDefinitionDaoPostgresImpl extends AbstractDaoPostgresImpl<ValueDefinition> implements ValueDefinitionDao {
    public ValueDefinitionDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
