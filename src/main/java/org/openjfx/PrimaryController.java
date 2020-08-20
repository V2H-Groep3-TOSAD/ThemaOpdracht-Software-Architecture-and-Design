package org.openjfx;

import java.io.IOException;

import javafx.fxml.FXML;
import org.services.PostgresServiceProvider;
import org.business.controllers.DefineBusinessRuleController;
import org.openjfx.DatabaseController;



public class PrimaryController {

    private DefineBusinessRuleController defineController = new DefineBusinessRuleController();
    private DatabaseController databaseController = new DatabaseController();

    @FXML
    private void switchToDefine() throws IOException {

        App.setRoot("database");




    }

    @FXML
    private void switchToGenerate() throws IOException {
        App.setRoot("generate");
    }
}
