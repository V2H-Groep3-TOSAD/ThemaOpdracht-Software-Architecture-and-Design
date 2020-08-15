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
public class ValueDefinition {

    private int valueDefinitionId;
    private String minValue;
    private String maxValue;
    private String literalValue;
    private String dataType;
}
