package org.definemodule.persistence.PostgresImpl;

import org.generatemodule.businesslogic.targetdomain.Person;
import org.definemodule.persistence.postgresdao.PersonDao;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonDaoPostgresImpl extends AbstractDaoPostgresImpl<Person> implements PersonDao {

    public PersonDaoPostgresImpl(EntityManager entityManager){
        super(entityManager);
    }

    @Override
    public List<Person> findByName(String name){
        @SuppressWarnings("unchecked")
        List<Person> persons = (List<Person>) em
                .createQuery("from Person where name=" + name).getResultList();
        if (!persons.isEmpty()) {
            System.out.println(persons);
            return persons;
        }
        return null;
    }
}
