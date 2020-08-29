package org.definemodule.businesslogic.services.postgresserviceimpl;
import org.generatemodule.businesslogic.targetdomain.Person;
import org.definemodule.persistence.postgresdao.PersonDao;
import org.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;

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
