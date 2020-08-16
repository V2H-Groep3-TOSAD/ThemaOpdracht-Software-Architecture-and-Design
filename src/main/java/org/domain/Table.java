package org.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<org.domain.Column> columns;

    @ManyToOne
    @JoinColumn(name = "database_id")
    private Database database;
}
