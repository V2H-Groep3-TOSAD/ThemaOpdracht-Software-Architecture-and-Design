package org.domain;

import javax.persistence.Table;
import javax.persistence.*;

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
}
