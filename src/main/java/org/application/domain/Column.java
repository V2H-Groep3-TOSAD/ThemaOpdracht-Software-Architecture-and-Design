package org.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "column_")
public class Column {
    @Id
    @SequenceGenerator(name = "column_SEQ", sequenceName = "SEQUENCE_COLUMN", initialValue = 10, allocationSize = 1)
    @GeneratedValue(generator = "column_SEQ")
    private int id;

    @javax.persistence.Column(name = "name")
    private String name;

    @javax.persistence.Column(name = "datatype")
    private String dataType;

    @ManyToMany(mappedBy = "columns")
    private List<BusinessRule> businessRules;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private org.application.domain.Table table;

    public String getName() {
        return name;
   }

    @Override
    public String toString() {
        return name;
    }
}
