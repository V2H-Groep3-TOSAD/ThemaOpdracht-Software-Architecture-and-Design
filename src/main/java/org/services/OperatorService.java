package org.services;

import org.domain.Operator;

import java.util.List;

public interface OperatorService {
    void saveOrUpdate(Operator operator);
    List<Operator> getAllOperators();
    Operator getOperatorById(int id);
    Operator getOperatorByName(String name);
}
