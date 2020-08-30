package org.generatemodule.persistence.PostgresImpl;

import org.definemodule.persistence.PostgresImpl.AbstractDaoPostgresImpl;
import org.generatemodule.businesslogic.targetdomain.Address;
import org.generatemodule.persistence.PostgresDao.AddressDao;

import javax.persistence.EntityManager;
import java.util.List;

public class AddressDaoPostgresImpl extends AbstractDaoPostgresImpl<Address> implements AddressDao {

    public AddressDaoPostgresImpl(EntityManager entityManager){
        super(entityManager);
    }

    @Override
    public List<Address> findByName(String name){
        @SuppressWarnings("unchecked")
        List<Address> addresses = (List<Address>) em
                .createQuery("from Address where name=" + name).getResultList();
        if (!addresses.isEmpty()) {
            System.out.println(addresses);
            return addresses;
        }
        return null;
    }
}
