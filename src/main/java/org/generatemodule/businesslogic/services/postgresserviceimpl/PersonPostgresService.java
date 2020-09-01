package org.generatemodule.businesslogic.services.postgresserviceimpl;
import org.generatemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
import org.generatemodule.businesslogic.targetdomain.Person;
import org.generatemodule.persistence.PostgresDao.PersonDao;

import java.util.List;

public class PersonPostgresService {
//        extends AbstractPostgresServiceImpl<Person> implements PersonService {
//    public PersonPostgresService(PersonDao personDao){
//        super(personDao);
//    };
    private PersonDao personDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public PersonPostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        personDao = postgresDaoImplProvider.getPersonDao();
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
