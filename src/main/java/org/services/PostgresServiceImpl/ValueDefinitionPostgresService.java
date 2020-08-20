package org.services.PostgresServiceImpl;

import org.domain.ValueDefinition;
import org.persistence.PostgresImpl.PostgresImplService;
import org.persistence.ValueDefinitionDao;
import org.services.ValueDefinitionService;

import java.util.List;

public class ValueDefinitionPostgresService {
//        extends AbstractPostgresServiceImpl<ValueDefinition> implements ValueDefinitionService {
//    public ValueDefinitionPostgresService(ValueDefinitionDao valueDefinitionDao) {
//        super(valueDefinitionDao);
//    }
private ValueDefinitionDao valueDefinitionDao;
    private PostgresImplService postgresImplService;

    public ValueDefinitionPostgresService(){
        postgresImplService = new PostgresImplService();
        valueDefinitionDao = postgresImplService.getValueDefinitionDao();
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
