package org.generatemodule.businesslogic.triggerGenerators;

import org.domain.BusinessRule;

public class attributeRangeNotBetween {
    private String template = "create or replace trigger ? before insert on ? for each row begin if :new.? > ? then SQLSTATE '22003' SET MESSAGE_TEXT = 'De waarde valt boven de min value'; end if; if :new.? < ? then SQLSTATE '22003' SET MESSAGE_TEXT = 'De waarde valt onder de max value'; end if; end;";
    public String generateTrigger(BusinessRule businessRule){
        return null;
    }
}
