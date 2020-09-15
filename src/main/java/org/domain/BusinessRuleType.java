package org.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "businessruletype")
public class BusinessRuleType {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(mappedBy = "businessruletypes")
    private List<Operator> operators;

//    @OneToMany(mappedBy = "businessRuleType")
//    private List<BusinessRuleTypeOperator> operators;

//    public List<BusinessRuleTypeOperator> getOperators() {
//        return operators;
//    }

    public String toString(){
        return name;
    }
}
