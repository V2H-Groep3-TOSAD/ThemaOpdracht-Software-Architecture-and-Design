package org.presentation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

import javafx.stage.Stage;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.BusinessRuleBuilder;
import org.domain.BusinessRuleType;
import org.domain.Database;
import org.domain.Table;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();
    public BusinessRuleType businessRuleType;

    @FXML
    public ChoiceBox<Table> tablesBox;

    public void fillTables(Database database, BusinessRuleBuilder businessRuleBuilder){
        List<Table>allTables = defineBusinessRuleController.giveAllTablesByDatabase(database);
        tablesBox.getItems().addAll(allTables);
        System.out.println(businessRuleBuilder.getBusinessRuleType());

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

//public class TableController implements Initializable {
//
//    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();
//    public BusinessRuleType businessRuleType;
//
//    @FXML
//    public ChoiceBox<Table> tablesBox;
//
//    public void fillTables(Database database){
//        List<Table>allTables = defineBusinessRuleController.giveAllTablesByDatabase(database);
//        tablesBox.getItems().addAll(allTables);
//        System.out.println(getBusinessRuleType());
//    }
//

//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
//
//
//    public void nextKnopClick(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("column.fxml"));
//        Parent columnViewParent = loader.load();
//        Scene columnViewScene = new Scene(columnViewParent);
//
//        Table selectedTable = tablesBox.getSelectionModel().getSelectedItem();
//        ColumnController columnController = loader.getController();
//        System.out.println(selectedTable.getId());
//        columnController.fillColumns(selectedTable);
//
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(columnViewScene);
//        window.show();
//    }
//
//    @FXML
//    private void runTable() throws IOException {
//        App.setRoot("table");
//    }
//}