package org.definemodule.persistence.postgresdao;

import org.domain.BusinessRuleType;
import org.domain.BusinessRuleTypeOperator;

import java.util.List;

public interface BusinessRuleTypeOperatorDao extends GenericDAO<BusinessRuleTypeOperator> {
    List<BusinessRuleTypeOperator> getAllOperatorsByBusinessRuleType(BusinessRuleType businessRuleType);
}
