package org.business.domain.tool;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "businessruletype")
public class BusinessRuleType {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "businessRuleType")
    private List<BusinessRuleTypeOperators> operators;
}
