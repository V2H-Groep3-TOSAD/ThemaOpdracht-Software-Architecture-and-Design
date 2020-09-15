package org.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "database")
@Getter
@Setter
public class Database {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "database")
    private List<org.domain.Table> tables;

    public Database(){};

    public Database(String naam){
        name = naam;
    }

    public String toString(){
        return name;
    }

}
