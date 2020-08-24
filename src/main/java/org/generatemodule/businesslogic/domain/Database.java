package org.generatemodule.businesslogic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;


@Table(name = "database")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Database {


    @Id
    @GeneratedValue
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "database")
    private List<org.generatemodule.businesslogic.domain.Table> tables;

}
