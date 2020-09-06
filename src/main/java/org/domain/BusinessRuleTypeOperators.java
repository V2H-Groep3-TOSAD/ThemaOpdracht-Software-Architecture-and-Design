package org.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "businessruletype_operators")
public class BusinessRuleTypeOperators {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "businessruletype_id")
    private BusinessRuleType businessRuleType;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Operator operator;
}
