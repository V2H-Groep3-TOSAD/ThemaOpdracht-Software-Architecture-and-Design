package org.presentation;

import javafx.event.ActionEvent;
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
import org.application.domain.Table;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();
    private BusinessRuleBuilder businessRuleBuilder;

    @FXML
    public ChoiceBox<Table> tablesBox;

    public void fillTables(Database database, BusinessRuleBuilder businessRuleBuilder){
        List<Table>allTables = defineBusinessRuleController.giveAllTablesByDatabase(database);
        tablesBox.getItems().addAll(allTables);
        System.out.println(businessRuleBuilder.getBusinessRuleType());
        this.businessRuleBuilder = businessRuleBuilder;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: 1-9-2020
    }


    public void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("column.fxml"));
        Parent columnViewParent = loader.load();
        Scene columnViewScene = new Scene(columnViewParent);

        Table selectedTable = tablesBox.getSelectionModel().getSelectedItem();
        ColumnController columnController = loader.getController();
        System.out.println(selectedTable.getId());
        columnController.fillColumns(selectedTable, businessRuleBuilder);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(columnViewScene);
        window.show();
    }



}
