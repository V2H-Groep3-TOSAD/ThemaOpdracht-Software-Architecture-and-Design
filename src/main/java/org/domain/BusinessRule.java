package org.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "businessrule")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class BusinessRule {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

//    @Column(name = "volgnummer")
////    private int volgNummer;

    @ManyToOne
    @JoinColumn(name = "businessruletype_id", referencedColumnName = "id")
    private BusinessRuleType businessRuleType;

    @OneToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    private Operator operator;

    @OneToOne
    @JoinColumn(name = "valuedefinition_id", referencedColumnName = "id")
    private ValueDefinition valueDefinition;

    public BusinessRule(String name, String description, BusinessRuleType businessRuleType, Operator operator, ValueDefinition valueDefinition) {
        this.name = name;
        this.description = description;
        this.businessRuleType = businessRuleType;
        this.operator = operator;
        this.valueDefinition = valueDefinition;
    }
}
