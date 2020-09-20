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
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "table")
    private List<org.application.domain.Column> columns;

    @ManyToOne
    @JoinColumn(name = "database_id")
    private Database database;

//    @Id
//    @GeneratedValue
//    private int id;
//
//    @Column(name = "name")
//    private String name;
//
//    @OneToMany(mappedBy = "table")
//    private List<org.application.domain.Column> columns;
//
//    @ManyToOne
//    @JoinColumn(name = "database_id")
//    private Database database;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<org.application.domain.Column> getColumns() {
//        return columns;
//    }
//
//    public void setColumns(List<org.application.domain.Column> columns) {
//        this.columns = columns;
//    }
//
//    public Database getDatabase() {
//        return database;
//    }
//
//    public void setDatabase(Database database) {
//        this.database = database;
//    }
//
//    public String toString(){
//        return name;
//    }


}
