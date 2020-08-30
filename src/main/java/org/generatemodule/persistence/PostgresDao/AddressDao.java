package org.generatemodule.persistence.PostgresDao;

import org.definemodule.persistence.postgresdao.GenericDAO;
import org.generatemodule.businesslogic.targetdomain.Address;

import java.util.List;

public interface AddressDao extends GenericDAO<Address> {
    List<Address> findByName(String name);
}
