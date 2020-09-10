package org.application.definemodule.persistence.postgresdao;

import org.application.domain.Table;

import java.util.List;

public interface TableDao  extends GenericDAO<Table> {

    List<Table> findByDatabaseId(int id);
}
