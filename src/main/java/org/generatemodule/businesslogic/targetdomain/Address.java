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

    public Address(int id, String postal, int housenr, int rent, int deposit, Person person) {
        this.id = id;
        this.postal = postal;
        this.housenr = housenr;
        this.rent = rent;
        this.deposit = deposit;
        this.person = person;
    }
}
