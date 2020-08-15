package org.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operator")

public class Operator {

    @Id
    @GeneratedValue
    private int Id;

    private String name;

    public String getName() {
        return name;
    }
}
