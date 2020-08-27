package org.business.domain.source;

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
    private List<org.business.domain.source.Column> columns;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<org.business.domain.source.Column> getColumns() {
        return columns;
    }

    public void setColumns(List<org.business.domain.source.Column> columns) {
        this.columns = columns;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }


}
