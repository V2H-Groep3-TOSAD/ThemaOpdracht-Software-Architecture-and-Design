package org.business.domain;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.List;


@Entity
@javax.persistence.Table(name = "database_table")
public class Table {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "table")
    private List<org.business.domain.Column> columns;

    @ManyToOne
    @JoinColumn(name = "database_id")
    private Database database;
}
