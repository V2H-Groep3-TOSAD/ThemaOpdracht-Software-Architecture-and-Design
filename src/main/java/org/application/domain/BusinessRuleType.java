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
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(mappedBy = "businessRuleTypes")
    private List<Operator> operators;

//    @Id
//    @GeneratedValue
//    private int id;
//
//    @Column(name = "name")
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    private Category category;
//
//    @OneToMany(mappedBy = "businessRuleType")
//    private List<BusinessRuleTypeOperator> operators;
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public List<BusinessRuleTypeOperator> getOperators() {
//        return operators;
//    }

    public String toString(){
        return name;
    }
}
