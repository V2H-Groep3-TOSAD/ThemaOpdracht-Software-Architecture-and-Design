package org.definemodule.businesslogic.services.PostgresServiceImpl;

import org.domain.ValueDefinition;
import org.definemodule.persistence.postgresdao.ValueDefinitionDao;
import org.definemodule.persistence.postgresdaoimpl.PostgresDaoImplProvider;

import java.util.List;

public class ValueDefinitionPostgresService {
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
