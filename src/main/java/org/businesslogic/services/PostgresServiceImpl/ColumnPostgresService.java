package org.businesslogic.services.PostgresServiceImpl;

import org.businesslogic.domain.Column;
import org.persistence.postgresdao.ColumnDao;
import org.businesslogic.services.postgresservice.ColumnService;

public class ColumnPostgresService extends AbstractPostgresServiceImpl<Column> implements ColumnService {
    public ColumnPostgresService(ColumnDao columnDao) {
        super(columnDao);
    };
}
