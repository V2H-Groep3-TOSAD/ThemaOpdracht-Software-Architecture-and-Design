package org.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "businessruletype_operators")
public class BusinessRuleTypeOperator {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "businessruletype_id")
    private BusinessRuleType businessRuleType;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Operator operator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusinessRuleType getBusinessRuleType() {
        return businessRuleType;
    }

    public void setBusinessRuleType(BusinessRuleType businessRuleType) {
        this.businessRuleType = businessRuleType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
