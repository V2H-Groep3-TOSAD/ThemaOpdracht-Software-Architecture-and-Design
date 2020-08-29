package org.definemodule.businesslogic.services.postgresserviceimpl;

import org.domain.Column;
import org.definemodule.persistence.postgresdao.ColumnDao;
import org.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;

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
