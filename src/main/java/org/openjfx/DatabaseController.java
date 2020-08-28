package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.business.controllers.DefineBusinessRuleController;
import org.business.domain.Database;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {

    DefineBusinessRuleController defineController = new DefineBusinessRuleController();
    PrimaryController primaryController = new PrimaryController();
    @FXML
    ChoiceBox<String> databaseBox;



    public void initialize() {
        System.out.println(defineController.giveAllDatabases());

        ArrayList<Database> lijst = (ArrayList<Database>)defineController.giveAllDatabases();

        ObservableList<String> options = FXCollections.observableArrayList();
        for(Database db : lijst){
            System.out.println(db.getName());
            options.add(db.getName());
        }
        System.out.println(options);
        databaseBox.getItems().addAll(options);


    }

    @FXML
    private void nextKnopClick() throws IOException {
        App.setRoot("table");

        String selectedChoice = databaseBox.getSelectionModel().getSelectedItem();
        primaryController.transferMessageDatabaseToTable(selectedChoice);
        //System.out.println(selectedChoice);
    }

//    private void loadSceneAndSendMessage(String messageString, String resourceString) {
//        try {
//            //Load second scene
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceString));
//            Parent root = loader.load();
//
//            //Show scene 2 in new window
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.setTitle("Second Window");
//            stage.show();
//        } catch (IOException ex) {
//            System.err.println(ex);
//        }
//    }
}
