package org.application.generatemodule.businesslogic.triggerGenerators;

import org.application.domain.BusinessRule;

public class ICMPGenerator extends GenericTriggerGenerator {
    private String template =
            "CREATE OR REPLACE FUNCTION %s_function() " //1
                    +   "RETURNS TRIGGER AS "
                    + "$BODY$ "
                    +   "DECLARE "
                    +       "%s_%s integer; " //2, 3 //integer evt variabel maken met attribute "dataType" in column
                    +   "BEGIN "
                    +       "SELECT %s.%s INTO %s_%s " //4, 5, 6, 7
                    +       "FROM %s, %s " //8, 9
                    +       "WHERE %s.id = %s.%s_id " //10, 11, 12
                    +       "AND %s.id = NEW.id; " //13

                    +       "IF (NEW.%s %s %s_%s) THEN " //16, 17, 18, 19
                    +           "RAISE EXCEPTION '%s' " //20
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
                businessRule.getColumns().get(1).getTable().getName(),
                businessRule.getColumns().get(1).getName(),
                businessRule.getColumns().get(1).getTable().getName(),
                businessRule.getColumns().get(1).getName(),
                businessRule.getColumns().get(1).getTable().getName(),
                businessRule.getColumns().get(1).getName(),
                businessRule.getColumns().get(1).getTable().getName(),
                businessRule.getColumns().get(0).getTable().getName(), //9
                businessRule.getColumns().get(1).getTable().getName(), //10
                businessRule.getColumns().get(0).getTable().getName(), //11
                businessRule.getColumns().get(1).getTable().getName(), //12
                businessRule.getColumns().get(0).getTable().getName(), //13
                businessRule.getColumns().get(0).getName(), //16
                businessRule.getOperator().getName(), //17
                businessRule.getColumns().get(1).getTable().getName(), //18
                businessRule.getColumns().get(1).getName(), //19
                message);


        String genericTriggerTemplate = generateGenericTrigger(businessRule);

        template += " " + genericTriggerTemplate;

        return template;
    }
}
