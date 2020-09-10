package org.application.generatemodule.persistence.PostgresDao;

import org.application.definemodule.persistence.postgresdao.GenericDAO;
import org.application.generatemodule.businesslogic.domain.Address;

import java.util.List;

public interface AddressDao extends GenericDAO<Address> {
    List<Address> findByName(String name);
}
