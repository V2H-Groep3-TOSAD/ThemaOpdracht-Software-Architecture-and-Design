package org.services.PostgresServiceImpl;

import org.domain.Table;
import org.persistence.PostgresImpl.PostgresImplService;
import org.persistence.TableDao;
import org.services.TableService;

import java.util.List;

public class TablePostgresService {
//    extends
//} AbstractPostgresServiceImpl<Table> implements TableService {
//    public TablePostgresService(TableDao tableDao){
//        super(tableDao);
//    };
    private TableDao tableDao;
    private PostgresImplService postgresImplService;

    public TablePostgresService(){
        postgresImplService = new PostgresImplService();
        tableDao = postgresImplService.getTableDao();
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
}
