package org.application.definemodule.businesslogic.services;

import org.application.domain.ValueDefinition;
import org.application.definemodule.persistence.postgresdao.ValueDefinitionDao;

public class ValueDefinitionService  {

//    public ValueDefinitionService(ValueDefinitionDao valueDefinitionDao) {
//        super(valueDefinitionDao);
//    }
    private final ValueDefinitionDao valueDefinitionDao;
//    private PostgresDaoImplProvider postgresDaoImplProvider;
//
    public ValueDefinitionService(ValueDefinitionDao valueDefinitionDao){
        this.valueDefinitionDao = valueDefinitionDao;
    };
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