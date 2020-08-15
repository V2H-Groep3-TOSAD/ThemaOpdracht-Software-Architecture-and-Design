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
public class BusinessRuleType {

    private int businessRuleTypeId;
    private String name;
    private String templateCode;
    private String code;
}
