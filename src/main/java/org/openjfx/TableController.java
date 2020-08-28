package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.business.domain.Database;
import org.business.domain.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableController {

    ChoiceBox<String> tablesBox;



    public void initialize(List<Table> allTables) {

        ObservableList<String> options = FXCollections.observableArrayList();
        for(Table table : allTables){
            options.add(table.getName());
        }
        tablesBox.getItems().addAll(options);


    }

    @FXML
    private void nextKnopClick() throws IOException {
        App.setRoot("column");
    }
}
