package org.openjfx;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.business.domain.tool.Database;
import org.business.domain.tool.Table;
import org.services.PostgresServiceProvider;
import org.business.controllers.DefineBusinessRuleController;
import org.openjfx.DatabaseController;



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
