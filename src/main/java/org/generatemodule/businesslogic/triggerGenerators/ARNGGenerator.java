package org.generatemodule.businesslogic.triggerGenerators;

import org.domain.BusinessRule;

public class ARNGGenerator {
//    private String template = "create or replace trigger ? "
//            + "before insert on ? "
//            + "for each row begin if :new.? <= ? "
//            + "then SQLSTATE '22000' SET MESSAGE_TEXT = 'De waarde is niet groter';"
//            + " end if;"
//            + " end;";

    private String template = "create or replace trigger %s "
            + "before insert on %s "
            + "for each row begin if :new.%s < %d "
            + "then SQLSTATE '22003' SET MESSAGE_TEXT = 'De waarde valt onder de min value'; "
            + "end if; "
            + "if :new.%s > %d "
            + "then SQLSTATE '22003' SET MESSAGE_TEXT = 'De waarde valt boven de max value'; "
            + "end if; " +
            "end;";

    public String generateTrigger (BusinessRule businessRule) {
        String message1 = "";
        String message2 = "";

        if (businessRule.getBusinessRuleType().getName().equals("Between")) {
            message1 = "De waarde valt onder de min value";
            message2 = "De waarde valt boven de max value";
        } if(businessRule.getBusinessRuleType().getName().equals("NotBetween")) {
            message1 = "De waarde valt boven de min value";
            message2 = "De waarde valt onder de max value";
        }

        return template;
    }
}
