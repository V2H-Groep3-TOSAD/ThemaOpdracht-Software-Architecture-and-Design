package org.application.domain;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setLiteralValue(String literalValue) {
        this.literalValue = literalValue;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setBusinessRule(BusinessRule businessRule) {
        this.businessRule = businessRule;
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
}
