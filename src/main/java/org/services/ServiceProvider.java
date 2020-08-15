package org.services;

import org.domain.Operator;
import org.persistence.OperatorDao;
import org.persistence.PostgresImplService;

import java.util.List;

public class ServiceProvider {
    private PostgresImplService postgresImplService;
    private OperatorDao operatorDao;

    public ServiceProvider(){
        postgresImplService = new PostgresImplService();
        operatorDao = postgresImplService.getOperatorDao();
    }

    public OperatorDao getOperatorDao() {
        return operatorDao;
    }
}
