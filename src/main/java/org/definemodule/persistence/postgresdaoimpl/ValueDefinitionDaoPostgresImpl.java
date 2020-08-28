package org.definemodule.persistence.postgresdaoimpl;

import org.domain.ValueDefinition;
import org.definemodule.persistence.postgresdao.ValueDefinitionDao;

import javax.persistence.EntityManager;

public class ValueDefinitionDaoPostgresImpl extends AbstractDaoPostgresImpl<ValueDefinition> implements ValueDefinitionDao {
    public ValueDefinitionDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
