package org.presentation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.Database;
import org.domain.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {

    private DefineBusinessRuleController defineController = new DefineBusinessRuleController();
    private TableController tableController = new TableController();
    @FXML
    private ChoiceBox<String> databaseBox;
    private String message;



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
        String selectedChoice = databaseBox.getSelectionModel().getSelectedItem();
        //tableController = new TableController();
        transferMessageDatabaseToTable(selectedChoice);
        //App.setRoot("table");
    }

    public void transferMessageDatabaseToTable(String message) throws IOException {
        String dbNaam = message;
        List<Database> databases = defineController.giveAllDatabases();
        for (Database db : databases) {
            System.out.println("Hallo" + db.getName());
            if (db.getName().equals(dbNaam)) {
                System.out.println("geigvdd"+ db.getName());
                List<Table> allTables = defineController.giveAllTablesByDatabase(db);
                ObservableList<String> options = FXCollections.observableArrayList();
                for (Table table : allTables) {
                    System.out.println(table);
                    options.add(table.getName());
//                    System.out.println(getTableController());
//                    System.out.println(getTableController().tablesBox);
//                    tableController.tablesBox.getItems().addAll(options);
                    //tableController.setTables(allTables);
                    //tableController.initialize(allTables);
                    try {
                        tableController.initialize(allTables);
                        //App.setRoot("table");
                    }catch (Exception e){
                        e.toString();
                    }
                }
            }
        }

        }

    public TableController getTableController(){
        return tableController;}
//    public String getMessage(){
//        return message;
//    }

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
