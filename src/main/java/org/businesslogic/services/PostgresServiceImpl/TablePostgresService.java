package org.businesslogic.services.PostgresServiceImpl;

import org.businesslogic.domain.Table;
import org.persistence.postgresdao.TableDao;
import org.businesslogic.services.postgresservice.TableService;

public class TablePostgresService extends AbstractPostgresServiceImpl<Table> implements TableService {
    public TablePostgresService(TableDao tableDao){
        super(tableDao);
    };
}
