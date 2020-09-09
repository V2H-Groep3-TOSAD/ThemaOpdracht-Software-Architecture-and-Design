package org.generatemodule.businesslogic.triggerGenerators;

import org.domain.BusinessRule;
import org.generatemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.generatemodule.persistence.PostgresImpl.PersonDaoPostgresImpl;
import org.hibernate.collection.internal.PersistentSortedMap;

public class ACMPGenerator extends GenericTriggerGenerator {

    private String template =
        "CREATE OR REPLACE FUNCTION %s_function() "
        +   "RETURNS TRIGGER AS "
        + "$BODY$ "
        +   "BEGIN "
        +       "IF (OLD.%s IS DISTINCT FROM NEW.%s AND NEW.%s %s '%s') THEN "
        +           "RAISE EXCEPTION '%s' "
        +           "USING ERRCODE = 22000; "
        +       "END IF; "

        +       "RETURN NEW; "
        +   "END "
        + "$BODY$ "
        + "LANGUAGE plpgsql SECURITY INVOKER; ";

    public String generateTrigger (BusinessRule businessRule) {
        String message = "";

        if (businessRule.getOperator().getName().equals("==")) {
            message = "De waarde is niet anders";
        } if (businessRule.getOperator().getName().equals("!=")) {
            message = "De waarde is niet gelijk";
        } if (businessRule.getOperator().getName().equals(">")) {
            message = "De waarde is niet kleiner of gelijk";
        } if (businessRule.getOperator().getName().equals("<")) {
            message = "De waarde is niet groter of gelijk";
        } if (businessRule.getOperator().getName().equals("<=")) {
            message = "De waarde is niet kleiner";
        } if (businessRule.getOperator().getName().equals(">=")) {
            message = "De waarde is niet groter";
        }

        template = String.format(template,
                businessRule.getName(),
                businessRule.getColumns().get(0).getName(),
                businessRule.getColumns().get(0).getName(),
                businessRule.getColumns().get(0).getName(),
                businessRule.getOperator().getName(),
                businessRule.getValueDefinition().getLiteralValue(),
                message);

        String genericTriggerTemplate = generateGenericTrigger(businessRule);

        template += genericTriggerTemplate;

        return template;
    }
}
