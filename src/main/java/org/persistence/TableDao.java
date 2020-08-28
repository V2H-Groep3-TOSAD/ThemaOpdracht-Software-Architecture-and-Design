package org.persistence;

import org.business.domain.tool.Table;

import java.util.List;

public interface TableDao  extends GenericDAO<Table> {

    List<Table> findByDatabaseId(int id);
}
