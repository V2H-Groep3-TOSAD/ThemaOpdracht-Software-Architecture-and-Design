package org.businesslogic.services.PostgresServiceImpl;

import org.businesslogic.domain.ValueDefinition;
import org.persistence.postgresdao.ValueDefinitionDao;
import org.businesslogic.services.postgresservice.ValueDefinitionService;

public class ValueDefinitionPostgresService extends AbstractPostgresServiceImpl<ValueDefinition> implements ValueDefinitionService {
    public ValueDefinitionPostgresService(ValueDefinitionDao valueDefinitionDao) {
        super(valueDefinitionDao);
    }

}
