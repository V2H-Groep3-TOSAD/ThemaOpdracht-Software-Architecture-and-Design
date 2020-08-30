package org.generatemodule.businesslogic.services.PostgresServiceImpl;

import org.generatemodule.businesslogic.targetdomain.Address;
import org.generatemodule.persistence.PostgresDao.AddressDao;
import org.generatemodule.persistence.PostgresImpl.PostgresDaoImplProvider;

import java.util.List;

public class AddressPostgresService {
    private AddressDao addressDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public AddressPostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        addressDao = postgresDaoImplProvider.getAddressDao();
    };


    public void saveOrUpdate(Address address){
        addressDao.insert(address);
    };

    public List<Address> getAllAddresss(){
        return addressDao.getAll();
    };

    public Address getAddressById(int id){
        return addressDao.findById(id);
    };
    public List<Address> getAddressByName(String name){
        return addressDao.findByName(name);
    };
}
