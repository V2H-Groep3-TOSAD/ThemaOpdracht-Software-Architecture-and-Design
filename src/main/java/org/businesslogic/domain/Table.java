package org.businesslogic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.List;


@Entity
@javax.persistence.Table(name = "database_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "table")
    private List<org.businesslogic.domain.Column> columns;

    @ManyToOne
    @JoinColumn(name = "database_id")
    private Database database;
}
