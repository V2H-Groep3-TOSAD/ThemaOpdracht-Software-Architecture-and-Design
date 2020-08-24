package org.businesslogic.services.PostgresServiceImpl;

import org.businesslogic.domain.Operator;
import org.persistence.postgresdao.OperatorDao;
import org.persistence.postgresdaoimpl.PostgresImplService;

import java.util.List;

public class OperatorPostgresService {
//        extends AbstractPostgresServiceImpl<Operator> implements OperatorService {
//    public OperatorPostgresService(OperatorDao operatorDao){
//        super(operatorDao);
//    };
    private OperatorDao operatorDao;
    private PostgresImplService postgresImplService;

    public OperatorPostgresService(){
        postgresImplService = new PostgresImplService();
        operatorDao = postgresImplService.getOperatorDao();
    };


    public void saveOrUpdate(Operator operator){
        operatorDao.insert(operator);
    };

    public List<Operator> getAllOperators(){
        return operatorDao.getAll();
    };

    public Operator getOperatorById(int id){
        return operatorDao.findById(id);
    };
    public List<Operator> getOperatorByName(String name){
        return operatorDao.findByName(name);
    };
}
