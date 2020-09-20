package org.application.definemodule.persistence.PostgresImpl;

import org.application.definemodule.persistence.postgresdao.*;
import org.application.generatemodule.persistence.PostgresDao.PersonDao;

public interface DaoProvider {
    OperatorDao getOperatorDao();

    TableDao getTableDao();

    BusinessRuleDao getBusinessRuleDao();

    BusinessRuleTypeDao getBusinessRuleTypeDao();

    CategoryDao getCategoryDao();

    ColumnDao getColumnDao();

    DatabaseDao getDatabaseDao();

    PersonDao getPersonDao();

//    BusinessRuleTypeOperatorDao getBusinessRuleTypeOperatorDao();

    ValueDefinitionDao getValueDefinitionDao();
}
