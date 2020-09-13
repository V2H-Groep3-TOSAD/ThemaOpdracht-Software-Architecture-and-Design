package org.application.definemodule.businesslogic.services;

import org.application.domain.Database;
import org.application.definemodule.persistence.postgresdao.DatabaseDao;

import java.util.List;

public class DatabaseService {
//    extends
//} AbstractPostgresServiceImpl<Database> implements DatabaseService {
//    public DatabasePostgresService(DatabaseDao databaseDao) {
//        super(databaseDao);
//    };
    private DatabaseDao databaseDao;
//    private PostgresDaoImplProvider postgresDaoImplProvider;

    public DatabaseService(DatabaseDao databaseDao){
        this.databaseDao = databaseDao;
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
