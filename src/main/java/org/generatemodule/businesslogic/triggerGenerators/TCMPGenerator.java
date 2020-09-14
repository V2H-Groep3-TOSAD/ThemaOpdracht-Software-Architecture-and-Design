package org.generatemodule.businesslogic.triggerGenerators;

import org.domain.BusinessRule;

public class TCMPGenerator extends GenericTriggerGenerator {
    private String template =
            "CREATE OR REPLACE FUNCTION %s_function() "
                    +   "RETURNS TRIGGER AS "
                    + "$BODY$ "
                    +   "BEGIN "
                    +       "IF (NEW.%s %s OLD.%s) THEN "
                    +           "RAISE EXCEPTION '%s' "
                    +           "USING ERRCODE = 22000; "
                    +       "END IF; "

                    +       "RETURN NEW; "
                    +   "END "
                    + "$BODY$ "
                    + "LANGUAGE plpgsql SECURITY INVOKER; ";

    public String generateTrigger (BusinessRule businessRule) {
        String message = "";

        if (businessRule.getOperator().getName().equals("=")) {
            message = "De waarde is niet anders dan: " + businessRule.getColumns().get(1).getName();
        } if (businessRule.getOperator().getName().equals("!=")) {
            message = "De waarde is niet gelijk dan: " + businessRule.getColumns().get(1).getName();
        } if (businessRule.getOperator().getName().equals(">")) {
            message = "De waarde is niet kleiner of gelijk aan: " + businessRule.getColumns().get(1).getName();
        } if (businessRule.getOperator().getName().equals("<")) {
            message = "De waarde is niet groter of gelijk aan: " + businessRule.getColumns().get(1).getName();
        } if (businessRule.getOperator().getName().equals("<=")) {
            message = "De waarde is niet kleiner dan " + businessRule.getColumns().get(1).getName();
        } if (businessRule.getOperator().getName().equals(">=")) {
            message = "De waarde is niet groter dan " + businessRule.getColumns().get(1).getName();
        }

        template = String.format(template,
                businessRule.getName(),
                businessRule.getColumns().get(0).getName(),
                businessRule.getOperator().getName(),
                businessRule.getColumns().get(1).getName(),
                message);

        String genericTriggerTemplate = generateGenericTrigger(businessRule);

        template += genericTriggerTemplate;

        return template;
    }
}
