package org.services;

import org.domain.Operator;
import org.persistence.OperatorDao;
import org.persistence.OperatorDaoPostgresImpl;

import java.util.List;

public class OperatorService extends ServiceProvider{
    private ServiceProvider serviceProvider;
    private OperatorDao operatorDao;
    public OperatorService(){
        serviceProvider = new ServiceProvider();
        operatorDao = serviceProvider.getOperatorDao();
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
