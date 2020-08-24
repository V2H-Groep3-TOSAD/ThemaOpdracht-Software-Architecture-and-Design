package org.businesslogic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
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
    private org.businesslogic.domain.Table table;
}
