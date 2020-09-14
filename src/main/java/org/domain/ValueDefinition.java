package org.domain;

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



    public int getId() {
        return id;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public String getLiteralValue() {
        return literalValue;
    }

    public String getDataType() {
        return dataType;
    }

    public BusinessRule getBusinessRule() {
        return businessRule;
    }

    public ValueDefinition(int min, int max, String literalValue) {
        this.minValue = min;
        this.maxValue = max;
        this.literalValue = literalValue;

    }

    public ValueDefinition(String literalValue) {
        this.literalValue = literalValue;
    }

    public ValueDefinition(){}

    public String toString(){
        return "Min: " + minValue + " Max: " + maxValue + " Literal Value: " + literalValue;
    }
}
