package org.generatemodule.businesslogic.services.postgresservice;

import org.generatemodule.businesslogic.services.PostgresServiceImpl.PersonPostgresService;
import org.generatemodule.persistence.target.PostgresDao.PersonDao;

public class PostgresServiceProvider {
    private PersonPostgresService personService;
    private PersonDao personDao;

    public PostgresServiceProvider(){
        personService = new PersonPostgresService();
    }

    public PersonPostgresService getPersonPostgresService(){return personService;}
}
