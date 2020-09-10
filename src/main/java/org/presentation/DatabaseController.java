package org.presentation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.application.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.application.domain.BusinessRuleBuilder;
import org.application.domain.Database;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DatabaseController implements Initializable {

    private DefineBusinessRuleController defineController = new DefineBusinessRuleController();
    private BusinessRuleBuilder businessRuleBuilder;

    @FXML
    private ChoiceBox<Database> databaseBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void fillDatabases(BusinessRuleBuilder businessRuleBuilder){
        this.businessRuleBuilder = businessRuleBuilder;
        ArrayList<Database> allDatabases = (ArrayList<Database>)defineController.giveAllDatabases();
        databaseBox.getItems().addAll(allDatabases);
    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("table.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);

        Database selectedDatabase = databaseBox.getSelectionModel().getSelectedItem();
        businessRuleBuilder.setDatabase(selectedDatabase);
        TableController tableController = loader.getController();
        tableController.fillTables(selectedDatabase, businessRuleBuilder);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    }
