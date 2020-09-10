package org.application.domain;

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

    public List<org.application.domain.Table> getTables() {
        return tables;
    }

    public void setTables(List<org.application.domain.Table> tables) {
        this.tables = tables;
    }

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "database")
    private List<org.application.domain.Table> tables;

    public Database(){};

    public Database(String naam){
        name = naam;
    }

    public String toString(){
        return name;
    }

}
