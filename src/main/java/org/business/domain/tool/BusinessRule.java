package org.business.domain.tool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
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
    private List<org.business.domain.tool.Column> columns;

    @OneToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    private Operator operator;

    @OneToOne
    @JoinColumn(name = "valuedefinition_id", referencedColumnName = "id")
    private ValueDefinition valueDefinition;

    public BusinessRule( String name, String description, int serialNumber, BusinessRuleType businessRuleType, Operator operator, ValueDefinition valueDefinition) {

        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.businessRuleType = businessRuleType;
        this.operator = operator;
        this.valueDefinition = valueDefinition;
    }
}
