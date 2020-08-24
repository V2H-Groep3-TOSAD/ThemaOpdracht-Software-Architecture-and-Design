package org.businesslogic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "valuedefinition")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValueDefinition {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "minvalue")
    private int minValue;

    @Column(name = "maxvalue")
    private int maxValue;

    @Column(name = "literalvalue")
    private String literalValue;

    @Column(name = "datatype")
    private String dataType;

    @OneToOne(mappedBy = "valueDefinition")
    private BusinessRule businessRule;
}
