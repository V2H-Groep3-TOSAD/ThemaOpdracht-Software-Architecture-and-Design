package org.domain;

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
public class Column {

    private int columnId;
    private String name;
}
