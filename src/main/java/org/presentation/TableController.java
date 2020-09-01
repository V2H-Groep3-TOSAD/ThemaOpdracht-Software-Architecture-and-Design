package org.presentation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.Database;
import org.domain.Table;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();

    @FXML
    public ChoiceBox<Table> tablesBox;

    public void fillTables(Database database){
        List<Table>allTables = defineBusinessRuleController.giveAllTablesByDatabase(database);
        tablesBox.getItems().addAll(allTables);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: 1-9-2020  
    }

    @FXML
    private void nextKnopClick() throws IOException {
        App.setRoot("column");
    }

    @FXML
    private void runTable() throws IOException {
        App.setRoot("table");
    }
}
