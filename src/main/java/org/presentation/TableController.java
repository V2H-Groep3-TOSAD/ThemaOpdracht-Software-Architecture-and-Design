package org.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.application.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.application.domain.Database;
import org.application.domain.Table;
import org.w3c.dom.events.Event;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController;

    @FXML
    public ChoiceBox<Table> tablesBox1;

    @FXML
    public ChoiceBox<Table> tablesBox2;

    @FXML
    private Text errorBox;

    private boolean volgendeScene = true;

    public void fillTables(Database database, DefineBusinessRuleController defineBusinessRuleController){
        this.defineBusinessRuleController = defineBusinessRuleController;
        List<Table>allTables = defineBusinessRuleController.giveAllTablesByDatabase(database);
        System.out.println("db tables" + allTables);
        tablesBox1.getItems().addAll(allTables);
        if (defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().toString().equals("ICMP")) {
            tablesBox2.getItems().addAll(allTables);
            tablesBox2.setVisible(true);
        }
        System.out.println(defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType());

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
        List<Table> allTablesSelected = new ArrayList<Table>() {};
        // TODO: foutmelding geen selectie
        if (tablesBox1.getSelectionModel().getSelectedItem() == null) {
            errorBox.setText("Er moet een selectie worden gemaakt");
        } else {
            allTablesSelected.add(tablesBox1.getSelectionModel().getSelectedItem());

            if (defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().toString().equals("ICMP")) {
                // TODO: foutmelding geen selectie
                // TODO: foutmelding zelfde tabel gekozen

                if (tablesBox1.getSelectionModel().getSelectedItem() == null || tablesBox2.getSelectionModel().getSelectedItem() == null) {
                    errorBox.setText("Er moet een selectie worden gemaakt");
                    volgendeScene = false;
                } else if (tablesBox1.getSelectionModel().getSelectedItem() == tablesBox2.getSelectionModel().getSelectedItem()) {
                        errorBox.setText("Je kan niet dezelfde tabel kiezen");
                        volgendeScene = false;
                    } else {
                        allTablesSelected.add(tablesBox2.getSelectionModel().getSelectedItem());
                        volgendeScene = true;
                    }
            }
                if (volgendeScene){
                    System.out.println("all select" + allTablesSelected);
                    defineBusinessRuleController.setTables(allTablesSelected);
                    ColumnController columnController = loader.getController();

                    columnController.fillColumns(allTablesSelected, defineBusinessRuleController);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(columnViewScene);
                    window.show();
                }

            }


        }

    }





//public class TableController implements Initializable {
//
//    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();
//    private BusinessRuleBuilder businessRuleBuilder;
//
//    @FXML
//    public ChoiceBox<Table> tablesBox1;
//
//    @FXML
//    public ChoiceBox<Table> tablesBox2;
//
//    public void fillTables(Database database, BusinessRuleBuilder businessRuleBuilder){
//        List<Table>allTables = defineBusinessRuleController.giveAllTablesByDatabase(database);
//        tablesBox1.getItems().addAll(allTables);
//        if (businessRuleBuilder.getBusinessRuleType().toString().equals("ICMP")) {
//            tablesBox2.getItems().addAll(allTables);
//            tablesBox2.setVisible(true);
//        }
//
//
//        System.out.println(businessRuleBuilder.getBusinessRuleType());
//        this.businessRuleBuilder = businessRuleBuilder;
//
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        // TODO: 1-9-2020
//    }
//
//
//    public void nextKnopClick(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("column.fxml"));
//        Parent columnViewParent = loader.load();
//        Scene columnViewScene = new Scene(columnViewParent);
//        List<Table> allTables = new ArrayList<Table>() {};
//
//        allTables.add(tablesBox1.getSelectionModel().getSelectedItem());
//
//        if (businessRuleBuilder.getBusinessRuleType().toString().equals("ICMP")) {
//            allTables.add(tablesBox2.getSelectionModel().getSelectedItem());
//        }
//
//        businessRuleBuilder.setTable(allTables);
//        ColumnController columnController = loader.getController();
//
//        columnController.fillColumns(allTables, businessRuleBuilder);
//
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(columnViewScene);
//        window.show();
//    }
//
//
//
//}
