package org.application.domain;

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
    @SequenceGenerator(name = "valuedefinition_SEQ", sequenceName = "SEQUENCE_VALUEDEFINITION", initialValue = 3, allocationSize = 1)
    @GeneratedValue(generator = "valuedefinition_SEQ")
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

    public ValueDefinition(int min, int max, String literalValue) {
        this.minValue = min;
        this.maxValue = max;
        this.literalValue = literalValue;
    }

    public ValueDefinition(String literalValue) {
        this.literalValue = literalValue;
    }

    public String toString(){
        return "Min: " + minValue + " Max: " + maxValue + " Literal Value: " + literalValue;
    }
}
