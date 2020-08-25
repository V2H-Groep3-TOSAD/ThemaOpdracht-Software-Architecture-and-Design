package org.business.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "valuedefinition")
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
