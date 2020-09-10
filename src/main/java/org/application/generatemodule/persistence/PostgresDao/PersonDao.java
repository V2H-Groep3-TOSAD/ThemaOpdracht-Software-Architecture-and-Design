package org.application.generatemodule.persistence.PostgresDao;

import org.application.definemodule.persistence.postgresdao.GenericDAO;
import org.application.generatemodule.businesslogic.domain.Person;

import java.util.List;

public interface PersonDao extends GenericDAO<Person> {

    List<Person> findByName(String name);
    void executeTrigger (String query);
}
