package org.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "businessrule")
public class BusinessRule {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "serialnumber")
    private int serialNumber;

    @ManyToOne
    @JoinColumn(name = "businessruletype_id", referencedColumnName = "id")
    private BusinessRuleType businessRuleType;

    @OneToMany
    private List<org.domain.Column> columns;

    @OneToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    private Operator operator;

    @OneToOne
    @JoinColumn(name = "valuedefinition_id", referencedColumnName = "id")
    private ValueDefinition valueDefinition;
}
