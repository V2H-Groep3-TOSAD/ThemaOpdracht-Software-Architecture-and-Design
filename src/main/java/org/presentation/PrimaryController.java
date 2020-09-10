package org.presentation;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.application.definemodule.businesslogic.services.postgresservice.PostgresServiceProvider;
import org.application.definemodule.businesslogic.controllers.DefineBusinessRuleController;


public class PrimaryController {

    private DefineBusinessRuleController defineController = new DefineBusinessRuleController();
    private PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();

    @FXML
    private void switchToDefine(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("businessRuleType.fxml"));
        Parent databaseViewParent = loader.load();

        Scene databaseViewScene = new Scene(databaseViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(databaseViewScene);
        window.show();
    }

    @FXML
    private void switchToGenerate(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("generate.fxml"));
        Parent databaseViewParent = loader.load();

        Scene databaseViewScene = new Scene(databaseViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(databaseViewScene);
        window.show();
    }

    private void switchToTable() throws IOException {
        App.setRoot("table");
    }










}
