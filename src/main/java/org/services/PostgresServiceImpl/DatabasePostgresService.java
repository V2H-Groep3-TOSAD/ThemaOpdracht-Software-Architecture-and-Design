package org.services.PostgresServiceImpl;

import org.domain.Database;
import org.persistence.DatabaseDao;
import org.persistence.PostgresImpl.PostgresImplService;
import org.services.DatabaseService;

import java.util.List;

public class DatabasePostgresService extends AbstractPostgresServiceImpl<Database> implements DatabaseService {
    public DatabasePostgresService(DatabaseDao databaseDao) {
        super(databaseDao);
    };
}
