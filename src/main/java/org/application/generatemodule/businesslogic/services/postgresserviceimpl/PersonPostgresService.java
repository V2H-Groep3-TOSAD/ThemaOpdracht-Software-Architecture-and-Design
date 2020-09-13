package org.application.generatemodule.businesslogic.services.postgresserviceimpl;
import org.application.generatemodule.persistence.PostgresImpl.PostgresDaoImplProvider;
import org.application.generatemodule.businesslogic.domain.Person;
import org.application.generatemodule.persistence.PostgresDao.PersonDao;

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

    public void executeTrigger(String query) { personDao.executeTrigger(query); };


}
