package org.generatemodule.persistence.PostgresDao;

import org.definemodule.persistence.postgresdao.GenericDAO;
import org.generatemodule.businesslogic.targetdomain.Person;

import java.util.List;

public interface PersonDao extends GenericDAO<Person> {
    List<Person> findByName(String name);
}
