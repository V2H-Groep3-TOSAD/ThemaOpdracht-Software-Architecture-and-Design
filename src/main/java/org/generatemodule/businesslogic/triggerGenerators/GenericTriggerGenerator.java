package org.generatemodule.businesslogic.triggerGenerators;

import org.domain.BusinessRule;

public abstract class GenericTriggerGenerator {

    public String generateGenericTrigger (BusinessRule businessRule) {
        String template =
            "DROP TRIGGER IF EXISTS %s "
            +   "ON %s; "

            + "CREATE TRIGGER %s "
            +   "BEFORE INSERT OR UPDATE OF %s ON %s "
            +   "FOR EACH ROW EXECUTE PROCEDURE %s_function();";

        template = String.format(template,
                businessRule.getName(),
                businessRule.getColumns().get(0).getTables().get(0).getName(),

                businessRule.getName(),
                businessRule.getColumns().get(0).getName(),
                businessRule.getColumns().get(0).getTables().get(0).getName(),
                businessRule.getName(),
                businessRule.getColumns().get(0).getTables().get(0).getName(),
                businessRule.getName());

        return template;
    }
}
