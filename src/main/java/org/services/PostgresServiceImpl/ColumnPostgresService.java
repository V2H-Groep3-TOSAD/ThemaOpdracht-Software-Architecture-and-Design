package org.services.PostgresServiceImpl;

import org.business.domain.Column;
import org.persistence.ColumnDao;
import org.persistence.PostgresImpl.PostgresDaoImplProvider;

import java.util.List;

public class ColumnPostgresService {
//        extends AbstractPostgresServiceImpl<Column> implements ColumnService {
//    public ColumnPostgresService(ColumnDao columnDao) {
//        super(columnDao);
//    };

    private ColumnDao columnDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public ColumnPostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        columnDao = postgresDaoImplProvider.getColumnDao();
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

    public List<Column> getColumnsByTableID(int id){ return columnDao.findByTableId(id);

    }
}
