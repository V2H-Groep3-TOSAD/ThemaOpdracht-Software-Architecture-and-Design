package org.definemodule.persistence.postgresdao;

import org.domain.Operator;

import java.util.List;

public interface OperatorDao extends GenericDAO<Operator> {
    List<Operator> findByName(String name);
}
