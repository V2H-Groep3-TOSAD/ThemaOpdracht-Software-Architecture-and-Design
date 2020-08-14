package org.openjfx.businesslogic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.Entity;
//import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Database {

    private int databaseId;
    private String code;
    private String name;

}
