package org.application.definemodule.persistence.postgresdao;

import org.application.domain.Database;

import java.util.List;

public interface DatabaseDao extends GenericDAO<Database>{

    List<Database> findByName(String name);
}
