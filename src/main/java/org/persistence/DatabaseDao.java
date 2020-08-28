package org.persistence;

import org.business.domain.tool.Database;

import java.util.List;

public interface DatabaseDao extends GenericDAO<Database>{

    List<Database> findByName(String name);
}
