package org.generatemodule.businesslogic.triggerGenerators;

import org.domain.BusinessRule;

public class ACMPGenerator {
    private String template = "create or replace trigger %s "
            + "before insert on %s "
            + "for each row begin if :new.%s == %s "
            + "then SQLSTATE '22000' SET MESSAGE_TEXT = %s; "
            + " end if; "
            + "end;";

    public String generateTrigger (BusinessRule businessRule) {
        String message = "";

        if (businessRule.getOperator().getName().equals("==")) {
            message = "De waarde is niet anders";
        } if(businessRule.getOperator().getName().equals("!=")) {
            message = "De waarde is niet gelijk";
        } if(businessRule.getOperator().getName().equals(">")) {
            message = "De waarde is niet kleiner of gelijk";
        } if(businessRule.getOperator().getName().equals("<")) {
            message = "De waarde is niet groter of gelijk";
        } if(businessRule.getOperator().getName().equals("<=")) {
            message = "De waarde is niet kleiner";
        } if(businessRule.getOperator().getName().equals(">=")) {
            message = "De waarde is niet groter";
        }

        template = String.format(template,  "'" + businessRule.getName() + "'",
                "'" + businessRule.getColumns().get(0).getTable().getName() + "'",
                "'" + businessRule.getColumns().get(0).getName() + "'",
                "'" + businessRule.getValueDefinition().getLiteralValue() + "'",
                "'" + message + "'");

        return template;
    }
}
