package org.definemodule.persistence.postgresdao;

import org.domain.Table;

import java.util.List;

public interface TableDao  extends GenericDAO<Table> {

    List<Table> findByDatabaseId(int id);
}
