package org.businesslogic.services.postgresservice;

import org.businesslogic.services.PostgresServiceImpl.*;
import org.persistence.postgresdao.*;

public class PostgresServiceProvider {
    private OperatorPostgresService operatorPostgresService;
    private TablePostgresService tablePostgresService;
    private BusinessRulePostgresService businessRulePostgresService;
    private BusinessRuleTypePostgresService businessRuleTypePostgresService;
    private CategoryPostgresService categoryPostgresService;
    private ColumnPostgresService columnPostgresService;
    private DatabasePostgresService databasePostgresService;
    private ValueDefinitionPostgresService valueDefinitionPostgresService;
    private BusinessRuleDao businessRuleDao;
    private OperatorDao operatorDao;
    private BusinessRuleTypeDao businessRuleTypeDao;
    private DatabaseDao databaseDao;
    private TableDao tableDao;
    private CategoryDao categoryDao;
    private ColumnDao columnDao;
    private ValueDefinitionDao valueDefinitionDao;

    public PostgresServiceProvider(){
//        operatorPostgresService = new OperatorPostgresService( {
//            @Override
//            public List<Operator> findByName(String name) {
//                return null;
//            }
//
//            @Override
//            public Operator findById(int id) {
//                return null;
//            }
//
//            @Override
//            public void update(Operator entity) {
//
//            }
//
//            @Override
//            public void delete(Operator entity) {
//
//            }
//
//            @Override
//            public List<Operator> getAll() {
//                return null;
//            }
//
//            @Override
//            public void insert(Operator entity) {
//
//            }
//        });
        operatorPostgresService = new OperatorPostgresService();
//        tablePostgresService = new TablePostgresService(tableDao);
//        businessRulePostgresService = new BusinessRulePostgresService(businessRuleDao);
//        businessRuleTypePostgresService = new BusinessRuleTypePostgresService(businessRuleTypeDao);
//        categoryPostgresService = new CategoryPostgresService(categoryDao);
//        columnPostgresService = new ColumnPostgresService(columnDao);
//        databasePostgresService = new DatabasePostgresService(databaseDao);
//        valueDefinitionPostgresService = new ValueDefinitionPostgresService(valueDefinitionDao);

    }

    public OperatorPostgresService getOperatorPostgresService() {
        return operatorPostgresService;
    }

    public TablePostgresService getTablePostgresService() {
        return tablePostgresService;
    }

    public BusinessRulePostgresService getBusinessRulePostgresService() {
        return businessRulePostgresService;
    }

    public BusinessRuleTypePostgresService getBusinessRuleTypePostgresService() {
        return businessRuleTypePostgresService;
    }

    public CategoryPostgresService getCategoryPostgresService() {
        return categoryPostgresService;
    }

    public ColumnPostgresService getColumnPostgresService() {
        return columnPostgresService;
    }

    public DatabasePostgresService getDatabasePostgresService() {
        return databasePostgresService;
    }

    public ValueDefinitionPostgresService getValueDefinitionPostgresService() {
        return valueDefinitionPostgresService;
    }


}
