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
@Getter
@Setter
public class Operator {

    @Id
    @GeneratedValue
    private int Id;

    @Column
    private String name;
}
