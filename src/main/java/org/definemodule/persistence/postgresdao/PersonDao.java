package org.definemodule.persistence.postgresdao;

import org.generatemodule.businesslogic.targetdomain.Person;

import java.util.List;

public interface PersonDao extends GenericDAO<Person> {
    List<Person> findByName(String name);
}
