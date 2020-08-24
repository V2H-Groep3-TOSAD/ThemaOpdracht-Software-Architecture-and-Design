package org.generatemodule.businesslogic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operator")
public class Operator {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "operator")
    private BusinessRule businessRule;

    @ManyToMany(mappedBy = "operators")
    private List<BusinessRuleType> businessRuleType;
}
