package org.services.PostgresServiceImpl;

import org.domain.ValueDefinition;
import org.persistence.PostgresImpl.PostgresImplService;
import org.persistence.ValueDefinitionDao;
import org.services.ValueDefinitionService;

import java.util.List;

public class ValueDefinitionPostgresService extends AbstractPostgresServiceImpl<ValueDefinition> implements ValueDefinitionService {
    public ValueDefinitionPostgresService(ValueDefinitionDao valueDefinitionDao) {
        super(valueDefinitionDao);
    }

}
