package org.generatemodule.businesslogic.triggerGenerators;

import org.domain.BusinessRule;

public class ARNGGenerator {

    private String template =
            "CREATE OR REPLACE FUNCTION %s"
                    +   "RETURNS TRIGGER AS"
                    + "$BODY$"
                    +   "BEGIN"
                    +       "IF (OLD.housenr IS DISTINCT FROM NEW.housenr AND NEW.housenr BETWEEN 1 AND 10) THEN"
                    +       "RAISE EXCEPTION 'De waarde valt niet buiten 1 en 10'"
                    +       "USING ERRCODE = 22000;"
                    +       "END IF;"

                    +       "IF (OLD.%s IS DISTINCT FROM NEW.%s AND NEW.%s %s %s) THEN"
                    +       "RAISE EXCEPTION %s"
                    +       "USING ERRCODE = 22000;"
                    +       "END IF;"

                    +       "RETURN NEW;"
                    +   "END"
                    + "$BODY$"
                    + "LANGUAGE plpgsql SECURITY INVOKER;";

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
