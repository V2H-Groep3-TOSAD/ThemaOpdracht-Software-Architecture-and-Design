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
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<BusinessRuleType> businessRuleType;
}
