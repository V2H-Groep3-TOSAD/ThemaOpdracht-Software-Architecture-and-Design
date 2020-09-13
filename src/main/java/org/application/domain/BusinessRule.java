package org.application.domain;

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
public class BusinessRule implements Buildable {

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
    @JoinTable(
            name = "businessrule_table_column",
            joinColumns = {@JoinColumn(name = "businessrule_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "columns_id", referencedColumnName = "id")}
    )
    List<org.application.domain.Column> columns;

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

    public List<org.application.domain.Column> getColumns() {
        return columns;
    }

    public Operator getOperator() {
        return operator;
    }

    public ValueDefinition getValueDefinition() {
        return valueDefinition;
    }

    public void addColumn(org.application.domain.Column column){
        getColumns().add(column);
    }

    public String toString(){
        return name + description + getId();
    }

    public static BusinessRuleBuilder builder() {
        return new BusinessRuleBuilder();
    }

    public static class BusinessRuleBuilder implements IBuilder {
        private String name;
        private String description;
        private int serialNumber;
        private BusinessRuleType businessRuleType;
        private Operator operator;
        private ValueDefinition valueDefinition;

        BusinessRuleBuilder(){
        }

        public BusinessRuleBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BusinessRuleBuilder description(String description) {
            this.description = description;
            return this;
        }

        public BusinessRuleBuilder serialNumber(int serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public BusinessRuleBuilder businessRuleType(BusinessRuleType businessRuleType) {
            this.businessRuleType = businessRuleType;
            return this;
        }

        public BusinessRuleBuilder operator(Operator operator) {
            this.operator = operator;
            return this;
        }

        public BusinessRuleBuilder valueDefinition(ValueDefinition valueDefinition) {
            this.valueDefinition = valueDefinition;
            return this;
        }

        public BusinessRule build() {
            // Check if all required fields are there
            return new BusinessRule(name, description, serialNumber, businessRuleType, operator, valueDefinition);
        }
    }
}
