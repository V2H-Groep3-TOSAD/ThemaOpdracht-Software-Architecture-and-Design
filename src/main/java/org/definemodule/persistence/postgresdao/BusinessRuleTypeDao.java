package org.definemodule.persistence.postgresdao;

import org.domain.BusinessRuleType;

public interface BusinessRuleTypeDao extends GenericDAO<BusinessRuleType> {
    BusinessRuleType findByName(String name);
}
