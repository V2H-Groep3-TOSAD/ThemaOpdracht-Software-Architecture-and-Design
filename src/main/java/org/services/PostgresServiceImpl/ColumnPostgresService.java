package org.services.PostgresServiceImpl;

import org.domain.Column;
import org.persistence.ColumnDao;
import org.persistence.PostgresImpl.PostgresImplService;
import org.services.ColumnService;

import java.util.List;

public class ColumnPostgresService extends AbstractPostgresServiceImpl<Column> implements ColumnService {
    public ColumnPostgresService(ColumnDao columnDao) {
        super(columnDao);
    };
}
