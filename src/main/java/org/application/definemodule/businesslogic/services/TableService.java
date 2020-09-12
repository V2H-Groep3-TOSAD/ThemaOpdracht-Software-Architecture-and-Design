package org.application.definemodule.businesslogic.services;

import org.application.domain.Table;
import org.application.definemodule.persistence.postgresdao.TableDao;

import java.util.List;

public class TableService {
//    extends
//} AbstractPostgresServiceImpl<Table> implements TableService {
//    public TablePostgresService(TableDao tableDao){
//        super(tableDao);
//    };
    private final TableDao tableDao;
//    private PostgresDaoImplProvider postgresDaoImplProvider;

    public TableService(TableDao tableDao){

        this.tableDao = tableDao;
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
