package org.domain;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Entity
@Table(name = "operator")
public class Operator {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;
//
//    @OneToOne(mappedBy = "operator")
//    private BusinessRule businessRule;

    @OneToMany(mappedBy = "operator")
    private List<BusinessRule> businessRules;

    @ManyToMany
    @JoinTable (name = "operator_businessruletype",
                joinColumns = { @JoinColumn(name = "operator_id", referencedColumnName = "id")},
                inverseJoinColumns = { @JoinColumn(name = "businessruletype_id", referencedColumnName = "id")}
    )
    private List<BusinessRuleType> businessRuleTypes;

//    @OneToMany(mappedBy = "operator")
//    private List<BusinessRuleTypeOperator> businessRuleType;


    public String toString(){
        return name;
    }
}
