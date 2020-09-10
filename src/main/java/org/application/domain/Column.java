package org.application.domain;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "table_column")
public class Column {

    @Id
    @GeneratedValue
    private int id;

    @javax.persistence.Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private org.application.domain.Table table;

    @ManyToMany(mappedBy = "columns")
    private List<BusinessRule> businessRules;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public org.application.domain.Table getTable() {
        return table;
    }

    public List<BusinessRule> getBusinessRules() {
        return businessRules;
    }

    public void addBusinessRules(BusinessRule businessRule) {
        this.businessRules.add(businessRule);
    }

    @Override
    public String toString() {
        return name;
//        return "Column{" +
//                "id=" + id +
//                ", name='" + name + '\'' + ", table=" + table.getId() +
//                '}';
    }
}
