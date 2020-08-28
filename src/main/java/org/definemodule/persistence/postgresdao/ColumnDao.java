package org.definemodule.persistence.postgresdao;

import org.domain.Column;

import java.util.List;

public interface ColumnDao extends GenericDAO<Column>{
    List<Column> findByTableId(int id);
}
