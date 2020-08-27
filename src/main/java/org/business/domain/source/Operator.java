package org.business.domain.source;

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
    private List<BusinessRuleTypeOperators> businessRuleType;
}
