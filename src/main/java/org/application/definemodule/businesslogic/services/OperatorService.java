package org.application.definemodule.businesslogic.services;

import org.application.domain.Operator;
import org.application.definemodule.persistence.postgresdao.OperatorDao;

public class OperatorService extends AbstractService<Operator> {
//        extends AbstractPostgresServiceImpl<Operator> implements OperatorService {
//    public OperatorPostgresService(OperatorDao operatorDao){
//        super(operatorDao);
//    };
//    private OperatorDao operatorDao;
//    private PostgresDaoImplProvider postgresDaoImplProvider;

    public OperatorService(OperatorDao operatorDao){
        super(operatorDao);
    };

//
//    public void saveOrUpdate(Operator operator){
//        operatorDao.insert(operator);
//    };
//
//    public List<Operator> getAllOperators(){
//        return operatorDao.getAll();
//    };
//
//    public Operator getOperatorById(int id){
//        return operatorDao.findById(id);
//    };
//    public List<Operator> getOperatorByName(String name){
//        return operatorDao.findByName(name);
//    };
}
