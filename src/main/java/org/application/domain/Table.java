package org.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@javax.persistence.Table(name = "table_")
public class Table {

    @Id
    @SequenceGenerator(name = "table_SEQ", sequenceName = "SEQUENCE_TABLE", initialValue = 3, allocationSize = 1)
    @GeneratedValue(generator = "table_SEQ")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "table")
    private List<org.application.domain.Column> columns;

    @ManyToOne
    @JoinColumn(name = "database_id")
    private Database database;

    public String toString(){
        return name;
    }
}
