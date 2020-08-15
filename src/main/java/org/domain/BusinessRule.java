package org.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "businessrule")
public class BusinessRule {

    @Id
    @GeneratedValue
    private int Id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int volgnummer;
}
