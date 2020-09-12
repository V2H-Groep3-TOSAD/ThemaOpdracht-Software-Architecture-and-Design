package org.application.definemodule.businesslogic.services;

import org.application.domain.ValueDefinition;
import org.application.definemodule.persistence.postgresdao.ValueDefinitionDao;

public class ValueDefinitionService extends AbstractService<ValueDefinition> {

    public ValueDefinitionService(ValueDefinitionDao valueDefinitionDao) {
        super(valueDefinitionDao);
    }
//private ValueDefinitionDao valueDefinitionDao;
//    private PostgresDaoImplProvider postgresDaoImplProvider;
//
//    public ValueDefinitionPostgresService(){
//        postgresDaoImplProvider = new PostgresDaoImplProvider();
//        valueDefinitionDao = postgresDaoImplProvider.getValueDefinitionDao();
//    };
//
//
//    public void saveOrUpdate(ValueDefinition valueDefinition){
//        valueDefinitionDao.insert(valueDefinition);
//    };
//
//    public List<ValueDefinition> getAllValueDefinitions(){
//        return valueDefinitionDao.getAll();
//    };
//
//    public ValueDefinition getValueDefinitionById(int id){
//        return valueDefinitionDao.findById(id);
//    };
//}
}