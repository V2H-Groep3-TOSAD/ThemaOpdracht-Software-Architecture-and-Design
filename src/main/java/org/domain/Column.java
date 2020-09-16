package org.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "column_")
public class Column {

    @Id
    @GeneratedValue
    private int id;

    @javax.persistence.Column(name = "name")
    private String name;

    @javax.persistence.Column(name = "datatype")
    private String dataType;

    @ManyToMany(mappedBy = "columns")
    private List<BusinessRule> businessRules;

//    @JoinColumn(name = "table_id", referencedColumnName = "id")
//    private org.domain.Table table;


//    @ManyToMany
//    @JoinTable (
//            name = "column_table",
//            joinColumns = {@JoinColumn(name = "column_id",referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "table_id", referencedColumnName = "id")}
//    )
//    private List<org.domain.Table> tables;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private org.domain.Table table;

    @Override
    public String toString() {
        return name;
//        return "Column{" +
//                "id=" + id +
//                ", name='" + name + '\'' + ", table=" + table.getId() +
//                '}';
    }
}
