package org.generatemodule.businesslogic.services.triggerGenerators;

import org.domain.BusinessRule;

public class attributeRangeBetween {
    private String template = "create or replace trigger %s before insert on %s for each row begin if :new.%s < %d then SQLSTATE '22003' SET MESSAGE_TEXT = 'De waarde valt onder de min value'; end if; if :new.%s > %d then SQLSTATE '22003' SET MESSAGE_TEXT = 'De waarde valt boven de max value'; end if; end;";
    public String generateTrigger(BusinessRule businessRule){
        template = String.format("'" + businessRule.getName() + "'",
                "'" + businessRule.getColumns().get(0).getTable().getName() + "'",
                "'" + businessRule.getColumns().get(0).getName() + "'",
                businessRule.getValueDefinition().getMinValue(),
                "'" + businessRule.getColumns().get(0).getName() + "'",
                businessRule.getValueDefinition().getMaxValue());
        return template;
    }
}
