package org.generatemodule.businesslogic.targetdomain;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "postal")
    private String postal;

    @Column(name = "housenr")
    private String housenr;
}
