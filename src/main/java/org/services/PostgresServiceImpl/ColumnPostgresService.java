package org.services.PostgresServiceImpl;

import org.domain.Column;
import org.persistence.ColumnDao;
import org.persistence.PostgresImpl.PostgresImplService;
import org.services.ColumnService;

import java.util.List;

public class ColumnPostgresService {
//        extends AbstractPostgresServiceImpl<Column> implements ColumnService {
//    public ColumnPostgresService(ColumnDao columnDao) {
//        super(columnDao);
//    };

    private ColumnDao columnDao;
    private PostgresImplService postgresImplService;

    public ColumnPostgresService(){
        postgresImplService = new PostgresImplService();
        columnDao = postgresImplService.getColumnDao();
    };


    public void saveOrUpdate(Column column){
        columnDao.insert(column);
    };

    public List<Column> getAllColumns(){
        return columnDao.getAll();
    };

    public Column getColumnById(int id){
        return columnDao.findById(id);
    };
}
