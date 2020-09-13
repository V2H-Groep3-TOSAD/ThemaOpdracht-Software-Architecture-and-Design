package org.application.definemodule.persistence.postgresdao;

import org.application.domain.Column;

import java.util.List;

public interface ColumnDao extends GenericDAO<Column>{
    List<Column> findByTableId(int id);
}
