package org.businesslogic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "businessruletype")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRuleType {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "templatecode")
    private String templateCode;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany
    @JoinTable(name = "businessruletype_operators",
               joinColumns = {@JoinColumn(name = "businessruletype_id")},
               inverseJoinColumns = {@JoinColumn(name = "operator_id")})
    private List<Operator> operators;

}
