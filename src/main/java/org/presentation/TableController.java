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
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.*;
import org.w3c.dom.events.Event;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();
    private BusinessRuleBuilder businessRuleBuilder;

    @FXML
    public ChoiceBox<Table> tablesBox1;

    @FXML
    public ChoiceBox<Table> tablesBox2;

    public void fillTables(Database database, BusinessRuleBuilder businessRuleBuilder){
        List<Table>allTables = defineBusinessRuleController.giveAllTablesByDatabase(database);
        tablesBox1.getItems().addAll(allTables);
        if (businessRuleBuilder.getBusinessRuleType().toString().equals("ICMP")) {
            tablesBox2.getItems().addAll(allTables);
            tablesBox2.setVisible(true);
        }


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
        List<Table> allTables = new ArrayList<Table>() {};

        allTables.add(tablesBox1.getSelectionModel().getSelectedItem());

        if (businessRuleBuilder.getBusinessRuleType().toString().equals("ICMP")) {
            allTables.add(tablesBox2.getSelectionModel().getSelectedItem());
        }

        businessRuleBuilder.setTable(allTables);
        ColumnController columnController = loader.getController();

        columnController.fillColumns(allTables, businessRuleBuilder);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(columnViewScene);
        window.show();
    }



}
