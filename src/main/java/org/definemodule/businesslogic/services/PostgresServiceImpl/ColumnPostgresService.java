package org.definemodule.businesslogic.services.PostgresServiceImpl;

import org.domain.Column;
import org.definemodule.persistence.postgresdao.ColumnDao;
import org.definemodule.persistence.postgresdaoimpl.PostgresDaoImplProvider;

import java.util.List;

public class ColumnPostgresService {
    private ColumnDao columnDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public ColumnPostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        columnDao = postgresDaoImplProvider.getColumnDao();
    };


    public void saveOrUpdate(Column column){
        columnDao.insert(column);
    }

    public List<Column> getAllColumns(){
        return columnDao.getAll();
    }

    public Column getColumnById(int id){
        return columnDao.findById(id);
    }

    public List<Column> getColumnsByTableID(int id){ return columnDao.findByTableId(id);}
}
