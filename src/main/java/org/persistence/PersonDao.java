package org.persistence;

import org.business.domain.target.Person;

import java.util.List;

public interface PersonDao extends GenericDAO<Person> {
    List<Person> findByName(String name);
}
