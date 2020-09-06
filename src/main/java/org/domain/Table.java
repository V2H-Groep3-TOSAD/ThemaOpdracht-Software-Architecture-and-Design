package org.domain;

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

    @OneToMany(mappedBy = "table")
    private List<org.domain.Column> columns;

    @ManyToOne
    @JoinColumn(name = "database_id")
    private Database database;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<org.domain.Column> getColumns() {
        return columns;
    }

    public void setColumns(List<org.domain.Column> columns) {
        this.columns = columns;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public String toString(){
        return name;
    }


}
