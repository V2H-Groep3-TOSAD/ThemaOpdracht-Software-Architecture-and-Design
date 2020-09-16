package org.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToMany(cascade = { CascadeType.MERGE})
    @JoinTable (
            name = "businessrule_column",
            joinColumns = {@JoinColumn(name = "businessrule_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "column_id", referencedColumnName = "id")}
    )
    List<org.domain.Column> columns;

//    @OneToOne
//    @JoinColumn(name = "operator_id", referencedColumnName = "id")
//    private Operator operator;

    @ManyToOne
    @JoinColumn(name = "operator_id")
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public BusinessRuleType getBusinessRuleType() {
        return businessRuleType;
    }

    public List<org.domain.Column> getColumns() {
        return columns;
    }

    public Operator getOperator() {
        return operator;
    }

    public ValueDefinition getValueDefinition() {
        return valueDefinition;
    }

    public void addColumn(org.domain.Column column){
        getColumns().add(column);
    }

    public String toString(){
        return name + description + getId();
    }
}
