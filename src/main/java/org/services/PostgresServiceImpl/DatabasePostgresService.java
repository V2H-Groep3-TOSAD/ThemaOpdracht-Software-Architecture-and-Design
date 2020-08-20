package org.services.PostgresServiceImpl;

import org.domain.Database;
import org.persistence.DatabaseDao;
import org.persistence.PostgresImpl.PostgresImplService;
import org.services.DatabaseService;

import java.util.List;

public class DatabasePostgresService {
//    extends
//} AbstractPostgresServiceImpl<Database> implements DatabaseService {
//    public DatabasePostgresService(DatabaseDao databaseDao) {
//        super(databaseDao);
//    };
private DatabaseDao databaseDao;
    private PostgresImplService postgresImplService;

    public DatabasePostgresService(){
        postgresImplService = new PostgresImplService();
        databaseDao = postgresImplService.getDatabaseDao();
    };


    public void saveOrUpdate(Database database){
        databaseDao.insert(database);
    };

    public List<Database> getAllDatabases(){
        return databaseDao.getAll();
    };

    public Database getDatabaseById(int id){
        return databaseDao.findById(id);
    };
}
