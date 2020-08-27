package org.persistence;

import org.business.domain.source.Operator;

import java.util.List;

public interface OperatorDao extends GenericDAO<Operator> {
    List<Operator> findByName(String name);
}
