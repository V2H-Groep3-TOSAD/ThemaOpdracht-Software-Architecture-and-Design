package org.generatemodule.businesslogic.triggerGenerators;

import org.domain.BusinessRule;

public class attributeCompareNotEqual {
    private String template = "create or replace trigger %s "
                            + "before insert on %s "
                            + "for each row begin if :new.%s == %s "
                            + "then SQLSTATE '22000' SET MESSAGE_TEXT = 'De waarde is gelijk'; "
                            + " end if; "
                            + "end;";

    public String generateTrigger(BusinessRule businessRule){
        template = String.format(template,  "'" + businessRule.getName() + "'",
                "'" + businessRule.getColumns().get(0).getTable().getName() + "'",
                "'" + businessRule.getColumns().get(0).getName() + "'",
                "'" + businessRule.getValueDefinition().getLiteralValue() + "'");

        return template;
    }
}
