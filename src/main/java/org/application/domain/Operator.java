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
    @SequenceGenerator(name = "operator_SEQ", sequenceName = "SEQUENCE_OPERATOR", initialValue = 9, allocationSize = 1)
    @GeneratedValue(generator = "operator_SEQ")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "operator")
    private List<BusinessRule> businessRules;

    @ManyToMany
    @JoinTable (name = "operator_businessruletype",
            joinColumns = { @JoinColumn(name = "operator_id", referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name = "businessruletype_id", referencedColumnName = "id")}
    )
    private List<BusinessRuleType> businessRuleTypes;

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }
}
