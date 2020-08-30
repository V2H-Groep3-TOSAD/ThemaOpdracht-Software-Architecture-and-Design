package org.generatemodule.businesslogic.services.triggerGenerators;

import org.domain.BusinessRule;

public class attributeCompareGreaterOrEqual {
    private String template= "create or replace trigger ? before insert on ? for each row begin if :new.? > ? then SQLSTATE '22000' SET MESSAGE_TEXT = 'De waarde is niet kleiner of gelijk'; end if; end;";
    public String generateTrigger(BusinessRule businessRule){
        return null;
    }
}
