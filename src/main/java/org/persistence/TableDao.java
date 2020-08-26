package org.persistence;

import org.business.domain.Table;

import java.util.List;

public interface TableDao  extends GenericDAO<Table> {

    List<Table> findByDatabaseId(int id);
}
