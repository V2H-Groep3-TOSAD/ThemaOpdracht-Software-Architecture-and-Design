package org.generatemodule.persistence.PostgresDao;

import org.definemodule.persistence.postgresdao.GenericDAO;
import org.generatemodule.businesslogic.domain.Person;

import java.util.List;

public interface PersonDao extends GenericDAO<Person> {

    List<Person> findByName(String name);
    void executeTrigger (String query);
}
