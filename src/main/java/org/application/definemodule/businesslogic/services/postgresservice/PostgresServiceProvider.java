//package org.application.definemodule.businesslogic.services.postgresservice;
//
//import org.application.definemodule.businesslogic.services.postgresserviceimpl.*;
//import ColumnService;
//
//public class PostgresServiceProvider {
//    private OperatorPostgresService operatorPostgresService;
//    private org.application.definemodule.businesslogic.services.postgresserviceimpl.TablePostgresService tablePostgresService;
//    private BusinessRulePostgresService businessRulePostgresService;
//    private BusinessRuleTypePostgresService businessRuleTypePostgresService;
//    private CategoryPostgresService categoryPostgresService;
//    private ColumnService columnService;
//    private DatabasePostgresService databasePostgresService;
//    private ValueDefinitionPostgresService valueDefinitionPostgresService;
//    private BusinessRuleTypeOperatorPostgresService businessRuleTypeOperatorPostgresService;
////    private BusinessRuleDao businessRuleDao;
////    private OperatorDao operatorDao;
////    private BusinessRuleTypeDao businessRuleTypeDao;
////    private DatabaseDao databaseDao;
////    private TableDao tableDao;
////    private CategoryDao categoryDao;
////    private ColumnDao columnDao;
////    private ValueDefinitionDao valueDefinitionDao;
//
//    public PostgresServiceProvider(){
////        operatorPostgresService = new OperatorPostgresService( {
////            @Override
////            public List<Operator> findByName(String name) {
////                return null;
////            }
////
////            @Override
////            public Operator findById(int id) {
////                return null;
////            }
////
////            @Override
////            public void update(Operator entity) {
////
////            }
////
////            @Override
////            public void delete(Operator entity) {
////
////            }
////
////            @Override
////            public List<Operator> getAll() {
////                return null;
////            }
////
////            @Override
////            public void insert(Operator entity) {
////
////            }
////        });
//        operatorPostgresService = new OperatorPostgresService();
//        tablePostgresService = new TablePostgresService();
//        businessRulePostgresService = new BusinessRulePostgresService();
//        businessRuleTypePostgresService = new BusinessRuleTypePostgresService();
//        categoryPostgresService = new CategoryPostgresService();
//        columnService = new ColumnService();
//        databasePostgresService = new DatabasePostgresService();
//        valueDefinitionPostgresService = new ValueDefinitionPostgresService();
//        businessRuleTypeOperatorPostgresService = new BusinessRuleTypeOperatorPostgresService();
////        tablePostgresService = new TablePostgresService(tableDao);
////        businessRulePostgresService = new BusinessRulePostgresService(businessRuleDao);
////        businessRuleTypePostgresService = new BusinessRuleTypePostgresService(businessRuleTypeDao);
////        categoryPostgresService = new CategoryPostgresService(categoryDao);
////        columnPostgresService = new ColumnPostgresService(columnDao);
////        databasePostgresService = new DatabasePostgresService(databaseDao);
////        valueDefinitionPostgresService = new ValueDefinitionPostgresService(valueDefinitionDao);
//
//    }
//    public OperatorPostgresService getOperatorPostgresService() {
//        return operatorPostgresService;
//    }
//
//    public TablePostgresService getTablePostgresService() {
//        return tablePostgresService;
//    }
//
//    public BusinessRulePostgresService getBusinessRulePostgresService() {
//        return businessRulePostgresService;
//    }
//
//    public BusinessRuleTypePostgresService getBusinessRuleTypePostgresService() {
//        return businessRuleTypePostgresService;
//    }
//
//    public CategoryPostgresService getCategoryPostgresService() {
//        return categoryPostgresService;
//    }
//
//    public ColumnService getColumnPostgresService() {
//        return columnService;
//    }
//
//    public DatabasePostgresService getDatabasePostgresService() {
//        return databasePostgresService;
//    }
//
//    public ValueDefinitionPostgresService getValueDefinitionPostgresService() {
//        return valueDefinitionPostgresService;
//    }
//
//    public BusinessRuleTypeOperatorPostgresService getBusinessRuleTypeOperatorPostgresService() {
//        return businessRuleTypeOperatorPostgresService;
//    }
//}
