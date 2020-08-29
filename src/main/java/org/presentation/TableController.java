package org.presentation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import org.domain.Table;

import java.io.IOException;
import java.util.List;

public class TableController {

    @FXML
    public ChoiceBox<String> tablesBox;
    public List<Table> allTables;


    public void fillTables(List<Table> allTables){
        tablesBox = new ChoiceBox<>();
        ObservableList<String> options = FXCollections.observableArrayList();
        for(Table table : allTables){
            options.add(table.getName());
            System.out.println("tablecontroller " + table);
        }
        System.out.println(tablesBox);
        tablesBox.getItems().addAll(options);
    }
    public void initialize(List<Table> allTables) throws IOException{

       fillTables(allTables);
        runTable();

    }

    public void setTables(List<Table> tables){
        allTables = tables;
    }

    public ChoiceBox<String> getTablesBox() {
        return tablesBox;
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
