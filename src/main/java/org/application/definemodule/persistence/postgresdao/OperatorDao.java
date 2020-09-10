package org.application.definemodule.persistence.postgresdao;

import org.application.domain.Operator;

import java.util.List;

public interface OperatorDao extends GenericDAO<Operator> {
    List<Operator> findByName(String name);
}
