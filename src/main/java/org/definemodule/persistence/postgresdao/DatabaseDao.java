package org.definemodule.persistence.postgresdao;

import org.domain.Database;

import java.util.List;

public interface DatabaseDao extends GenericDAO<Database>{

    List<Database> findByName(String name);
}
