package org.generatemodule.businesslogic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.*;

@Table(name = "businessrule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRule {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "volgnummer")
    private int volgNummer;

    @ManyToOne
    @JoinColumn(name = "businessruletype_id", referencedColumnName = "id")
    private BusinessRuleType businessRuleType;

    @OneToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    private Operator operator;

    @OneToOne
    @JoinColumn(name = "valuedefinition_id", referencedColumnName = "id")
    private ValueDefinition valueDefinition;
}
