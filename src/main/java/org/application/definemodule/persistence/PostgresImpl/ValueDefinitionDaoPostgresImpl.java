package org.application.definemodule.persistence.PostgresImpl;

import lombok.Value;
import org.application.domain.ValueDefinition;
import org.application.definemodule.persistence.postgresdao.ValueDefinitionDao;

import javax.persistence.EntityManager;
import java.util.List;

public class ValueDefinitionDaoPostgresImpl extends AbstractDaoPostgresImpl<ValueDefinition> implements ValueDefinitionDao {
    public ValueDefinitionDaoPostgresImpl(EntityManager entityManager){super(entityManager);}

//    public List<ValueDefinition> findByValueDefinition(ValueDefinition valueDefinition){
//        String query = "Select from Valuedefinition where datatype=" + valueDefinition.getDataType() + " and literalvalue=" + valueDefinition.getLiteralValue()
//                +" and maxvalue=" + valueDefinition.getMaxValue() + " and minvalue=" + valueDefinition.getMinValue();
//        @SuppressWarnings("unchecked")
//        List<ValueDefinition> valueDefinitions = (List<ValueDefinition>) em
//                .createNativeQuery(query).getResultList();
//        if (!valueDefinitions.isEmpty()) {
//            return valueDefinitions;
//        }
//        return null;
//    }
}
