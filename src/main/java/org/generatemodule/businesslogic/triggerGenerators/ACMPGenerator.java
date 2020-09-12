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

        if (businessRule.getOperator().getName().equals("=")) {
            message = "De waarde is niet anders dan: '" + businessRule.getValueDefinition().getLiteralValue() + "'";
        } if (businessRule.getOperator().getName().equals("!=")) {
            message = "De waarde is niet gelijk dan: '" + businessRule.getValueDefinition().getLiteralValue() + "'";
        } if (businessRule.getOperator().getName().equals(">")) {
            message = "De waarde is niet kleiner of gelijk aan: '" + businessRule.getValueDefinition().getLiteralValue() + "'";
        } if (businessRule.getOperator().getName().equals("<")) {
            message = "De waarde is niet groter of gelijk aan: '" + businessRule.getValueDefinition().getLiteralValue() + "'";
        } if (businessRule.getOperator().getName().equals("<=")) {
            message = "De waarde is niet kleiner dan '" + businessRule.getValueDefinition().getLiteralValue() + "'";
        } if (businessRule.getOperator().getName().equals(">=")) {
            message = "De waarde is niet groter dan '" + businessRule.getValueDefinition().getLiteralValue() + "'";
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
