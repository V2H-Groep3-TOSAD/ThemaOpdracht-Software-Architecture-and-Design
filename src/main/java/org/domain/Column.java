package org.domain;

import javax.persistence.*;
import javax.persistence.Table;

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
    private org.domain.Table table;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public org.domain.Table getTable() {
        return table;
    }
}
