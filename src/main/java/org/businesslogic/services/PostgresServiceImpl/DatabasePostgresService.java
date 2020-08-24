package org.businesslogic.services.PostgresServiceImpl;

import org.businesslogic.domain.Database;
import org.persistence.postgresdao.DatabaseDao;
import org.businesslogic.services.postgresservice.DatabaseService;

public class DatabasePostgresService extends AbstractPostgresServiceImpl<Database> implements DatabaseService {
    public DatabasePostgresService(DatabaseDao databaseDao) {
        super(databaseDao);
    };
}
