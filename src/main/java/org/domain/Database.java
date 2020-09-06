package org.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "database")
public class Database {
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

    public List<org.domain.Table> getTables() {
        return tables;
    }

    public void setTables(List<org.domain.Table> tables) {
        this.tables = tables;
    }

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "database")
    private List<org.domain.Table> tables;

    public String toString(){
        return name;
    }

}
