package org.application.definemodule.businesslogic.services.postgresserviceimpl;

import org.application.domain.ValueDefinition;
import org.application.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
import org.application.definemodule.persistence.postgresdao.ValueDefinitionDao;

import java.util.List;

public class ValueDefinitionPostgresService {
//        extends AbstractPostgresServiceImpl<ValueDefinition> implements ValueDefinitionService {
//    public ValueDefinitionPostgresService(ValueDefinitionDao valueDefinitionDao) {
//        super(valueDefinitionDao);
//    }
private ValueDefinitionDao valueDefinitionDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public ValueDefinitionPostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        valueDefinitionDao = postgresDaoImplProvider.getValueDefinitionDao();
    };


    public void saveOrUpdate(ValueDefinition valueDefinition){
        valueDefinitionDao.insert(valueDefinition);
    };

    public List<ValueDefinition> getAllValueDefinitions(){
        return valueDefinitionDao.getAll();
    };

    public ValueDefinition getValueDefinitionById(int id){
        return valueDefinitionDao.findById(id);
    };
}