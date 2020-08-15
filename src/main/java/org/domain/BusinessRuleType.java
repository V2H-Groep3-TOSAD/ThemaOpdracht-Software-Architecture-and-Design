package org.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "businessruletype")
public class BusinessRuleType {

    @Id
    @GeneratedValue
    private int Id;

    @Column
    private String name;

    @Column
    private String templateCode;

    @Column
    private String code;
}
