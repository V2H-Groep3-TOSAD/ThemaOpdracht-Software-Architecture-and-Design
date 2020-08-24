package org.persistence.postgresdao;

import org.businesslogic.domain.Operator;

import java.util.List;

public interface OperatorDao extends GenericDAO<Operator> {
    List<Operator> findByName(String name);
}
