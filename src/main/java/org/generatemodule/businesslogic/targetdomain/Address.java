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
    private int housenr;

    @Column(name = "rent")
    private int rent;

    @Column(name = "deposit")
    private int deposit;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
