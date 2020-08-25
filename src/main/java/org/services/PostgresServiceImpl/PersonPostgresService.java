package org.services.PostgresServiceImpl;

import org.domain.target.Person;
import org.persistence.PersonDao;
import org.persistence.PostgresImpl.PostgresImplService;

import java.util.List;

public class PersonPostgresService {
//        extends AbstractPostgresServiceImpl<Person> implements PersonService {
//    public PersonPostgresService(PersonDao personDao){
//        super(personDao);
//    };
    private PersonDao personDao;
    private PostgresImplService postgresImplService;

    public PersonPostgresService(){
        postgresImplService = new PostgresImplService();
        personDao = postgresImplService.getPersonDao();
    };


    public void saveOrUpdate(Person person){
        personDao.insert(person);
    };

    public List<Person> getAllPersons(){
        return personDao.getAll();
    };

    public Person getPersonById(int id){
        return personDao.findById(id);
    };
    public List<Person> getPersonByName(String name){
        return personDao.findByName(name);
    };
}
