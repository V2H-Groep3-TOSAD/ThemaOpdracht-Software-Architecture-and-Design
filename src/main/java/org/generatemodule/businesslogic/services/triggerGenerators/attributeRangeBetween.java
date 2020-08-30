package org.generatemodule.businesslogic.services.triggerGenerators;

import org.domain.BusinessRule;

public class attributeRangeBetween {
    private String template = "create or replace trigger ? before insert on ? for each row begin if :new.? < ? then SQLSTATE '22003' SET MESSAGE_TEXT = 'De waarde valt onder de min value'; end if; if :new.? > ? then SQLSTATE '22003' SET MESSAGE_TEXT = 'De waarde valt boven de max value'; end if; end;";
    public String generateBusinessRule(BusinessRule businessRule){
        return null;
    }
}
