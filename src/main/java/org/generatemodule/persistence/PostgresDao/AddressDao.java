package org.generatemodule.persistence.PostgresDao;

import org.definemodule.persistence.postgresdao.GenericDAO;
import org.generatemodule.businesslogic.domain.Address;

import java.util.List;

public interface AddressDao extends GenericDAO<Address> {
    List<Address> findByName(String name);
}
