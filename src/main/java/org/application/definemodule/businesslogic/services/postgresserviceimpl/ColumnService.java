package org.application.definemodule.businesslogic.services.postgresserviceimpl;

import org.application.domain.Column;
import org.application.definemodule.persistence.postgresdao.ColumnDao;
import org.application.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;

import java.util.List;

public class ColumnService {

    private final ColumnDao columnDao;

    public ColumnService(ColumnDao columnDao){
        this.columnDao = columnDao;
    }

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
