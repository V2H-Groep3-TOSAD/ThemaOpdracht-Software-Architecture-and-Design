package org.generatemodule.businesslogic.services.postgresservice;

import org.generatemodule.businesslogic.services.postgresserviceimpl.AddressPostgresService;
import org.generatemodule.businesslogic.services.postgresserviceimpl.PersonPostgresService;

public class PostgresServiceProvider {
    private PersonPostgresService personPostgresService;
    private AddressPostgresService addressPostgresService;

    public PostgresServiceProvider(){

        personPostgresService = new PersonPostgresService();
        addressPostgresService = new AddressPostgresService();

    }

    public PersonPostgresService getPersonPostgresService(){return personPostgresService;}
    public AddressPostgresService getAddressPostgresService(){return addressPostgresService;}
}
