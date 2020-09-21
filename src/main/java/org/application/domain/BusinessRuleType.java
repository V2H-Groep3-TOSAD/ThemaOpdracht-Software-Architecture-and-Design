package org.application.domain;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "businessruletype")
public class BusinessRuleType {

    @Id
    @SequenceGenerator(name = "businessruletype_SEQ", sequenceName = "SEQUENCE_BUSINESSRULETYPE", initialValue = 5, allocationSize = 1)
    @GeneratedValue(generator = "businessruletype_SEQ")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(mappedBy = "businessRuleTypes")
    private List<Operator> operators;

    public String toString(){
        return name;
    }
}
