package org.application.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "operator")
public class Operator {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "operator")
    private BusinessRule businessRule;

    @OneToMany(mappedBy = "operator")
    private List<BusinessRuleTypeOperator> businessRuleType;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BusinessRule getBusinessRule() {
        return businessRule;
    }

    public List<BusinessRuleTypeOperator> getBusinessRuleType() {
        return businessRuleType;
    }

    public String toString(){
        return name;
    }
}
