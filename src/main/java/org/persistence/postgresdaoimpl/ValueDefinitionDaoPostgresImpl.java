package org.persistence.postgresdaoimpl;

import org.businesslogic.domain.ValueDefinition;
import org.persistence.postgresdao.ValueDefinitionDao;

import javax.persistence.EntityManager;

public class ValueDefinitionDaoPostgresImpl extends AbstractDaoPostgresImpl<ValueDefinition> implements ValueDefinitionDao {
    public ValueDefinitionDaoPostgresImpl(EntityManager entityManager){super(entityManager);}
}
