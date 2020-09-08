package org.definemodule.businesslogic.services.postgresserviceimpl;

import org.domain.Database;
import org.definemodule.persistence.postgresdao.DatabaseDao;
import org.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;

import java.util.List;

public class DatabasePostgresService {
//    extends
//} AbstractPostgresServiceImpl<Database> implements DatabaseService {
//    public DatabasePostgresService(DatabaseDao databaseDao) {
//        super(databaseDao);
//    };
private DatabaseDao databaseDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public DatabasePostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        databaseDao = postgresDaoImplProvider.getDatabaseDao();
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

    public List<Database> getDatabaseByName(String name){return databaseDao.findByName(name);}


}