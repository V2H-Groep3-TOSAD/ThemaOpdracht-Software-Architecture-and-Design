package org.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.List;


@Entity
@javax.persistence.Table(name = "_table")
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

    @ManyToMany(mappedBy = "tables")
    private List<org.domain.Column> columns;

    @ManyToOne
    @JoinColumn(name = "database_id")
    private Database database;

    public String toString(){
        return name;
    }


}
