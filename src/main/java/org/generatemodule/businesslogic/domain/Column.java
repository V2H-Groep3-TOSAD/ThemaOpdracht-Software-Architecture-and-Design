package org.generatemodule.businesslogic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;

@Table(name = "table_column")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Column {

    @Id
    @GeneratedValue
    private int id;

    @javax.persistence.Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private org.generatemodule.businesslogic.domain.Table table;
}
