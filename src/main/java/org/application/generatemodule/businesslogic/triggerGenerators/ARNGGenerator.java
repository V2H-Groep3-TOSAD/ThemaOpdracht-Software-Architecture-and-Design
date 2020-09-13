package org.application.generatemodule.businesslogic.triggerGenerators;

import org.application.domain.BusinessRule;

public class ARNGGenerator extends GenericTriggerGenerator {

    private String template =
            "CREATE OR REPLACE FUNCTION %s_function() "
                    +   "RETURNS TRIGGER AS "
                    + "$BODY$ "
                    +   "BEGIN "
                    +       "IF (OLD.%s IS DISTINCT FROM NEW.%s AND NEW.%s %s %s AND %s) THEN "
                    +           "RAISE EXCEPTION '%s' "
                    +           "USING ERRCODE = 22000; "
                    +       "END IF; "

                    +       "RETURN NEW; "
                    +   "END "
                    + "$BODY$ "
                    + "LANGUAGE plpgsql SECURITY INVOKER; ";

    public String generateTrigger (BusinessRule businessRule) {
        String message = "";

        if (businessRule.getOperator().getName().equals("BETWEEN")) {
            message =   "De waarde valt niet buiten " + businessRule.getValueDefinition().getMinValue() + " en "
                        + businessRule.getValueDefinition().getMaxValue();
        } if (businessRule.getOperator().getName().equals("NOT BETWEEN")) {
            message =   "De waarde valt niet binnen " + businessRule.getValueDefinition().getMinValue() + " en "
                    + businessRule.getValueDefinition().getMaxValue();
        }

        template = String.format(template,
                businessRule.getName(),
                businessRule.getColumns().get(0).getName(),
                businessRule.getColumns().get(0).getName(),
                businessRule.getColumns().get(0).getName(),
                businessRule.getOperator().getName(),
                businessRule.getValueDefinition().getMinValue(),
                businessRule.getValueDefinition().getMaxValue(),
                message);

        String genericTriggerTemplate = generateGenericTrigger(businessRule);

        template += genericTriggerTemplate;

        return template;
    }
}
