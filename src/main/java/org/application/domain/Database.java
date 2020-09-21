package org.application.domain;

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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Database {
    @Id
    @SequenceGenerator(name = "database_SEQ", sequenceName = "SEQUENCE_DATABASE", initialValue = 2, allocationSize = 1)
    @GeneratedValue(generator = "database_SEQ")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "database")
    private List<org.application.domain.Table> tables;

    public String toString(){
        return name;
    }

}
