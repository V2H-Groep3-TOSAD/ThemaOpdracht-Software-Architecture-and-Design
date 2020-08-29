package org.presentation;

import java.io.IOException;

import javafx.fxml.FXML;
import org.definemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;


public class PrimaryController {

    private DefineBusinessRuleController defineController = new DefineBusinessRuleController();
    private DatabaseController databaseController = new DatabaseController();
    private TableController tableController = new TableController();
    private PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();
    private String messageString;
    private String resoureceString;

    @FXML
    private void switchToDefine() throws IOException {

        App.setRoot("database");

    }

    @FXML
    private void switchToGenerate() throws IOException {
        App.setRoot("generate");
    }

    private void switchToTable() throws IOException {
        App.setRoot("table");
    }










}
