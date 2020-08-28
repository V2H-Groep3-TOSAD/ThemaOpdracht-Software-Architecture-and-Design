package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.Database;

import java.io.IOException;
import java.util.ArrayList;

public class DatabaseController {

    DefineBusinessRuleController defineController = new DefineBusinessRuleController();
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
        System.out.println(selectedChoice);
    }
}
