package org.persistence;

import org.business.domain.tool.Column;

import java.util.List;

public interface ColumnDao extends GenericDAO<Column>{
    List<Column> findByTableId(int id);
}
