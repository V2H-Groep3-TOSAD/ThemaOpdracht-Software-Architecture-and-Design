package org.business.domain.source;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "database")
public class Database {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<org.business.domain.source.Table> getTables() {
        return tables;
    }

    public void setTables(List<org.business.domain.source.Table> tables) {
        this.tables = tables;
    }

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "database")
    private List<org.business.domain.source.Table> tables;

}
