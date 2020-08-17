package org.services.PostgresServiceImpl;

import org.domain.Table;
import org.persistence.PostgresImpl.PostgresImplService;
import org.persistence.TableDao;
import org.services.TableService;

import java.util.List;

public class TablePostgresService extends AbstractPostgresServiceImpl<Table> implements TableService {
    public TablePostgresService(TableDao tableDao){
        super(tableDao);
    };
}
