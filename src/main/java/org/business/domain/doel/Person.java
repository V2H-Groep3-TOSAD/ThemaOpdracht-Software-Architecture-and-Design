package org.business.domain.doel;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
