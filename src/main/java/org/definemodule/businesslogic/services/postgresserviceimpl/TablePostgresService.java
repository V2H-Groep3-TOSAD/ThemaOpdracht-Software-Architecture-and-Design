package org.definemodule.businesslogic.services.postgresserviceimpl;

import org.domain.Table;
import org.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
import org.definemodule.persistence.postgresdao.TableDao;

import java.util.List;

public class TablePostgresService {
//    extends
//} AbstractPostgresServiceImpl<Table> implements TableService {
//    public TablePostgresService(TableDao tableDao){
//        super(tableDao);
//    };
    private TableDao tableDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public TablePostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        tableDao = postgresDaoImplProvider.getTableDao();
    };


    public void saveOrUpdate(Table table){
        tableDao.insert(table);
    };

    public List<Table> getAllTables(){
        return tableDao.getAll();
    };

    public Table getTableById(int id){
        return tableDao.findById(id);
    };

    public List<Table> getTablesByDatabaseId(int id){
        return tableDao.findByDatabaseId(id);
    }
}