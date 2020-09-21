package org.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import org.application.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.application.domain.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import org.application.domain.Table;

import javafx.event.ActionEvent;

import java.util.List;
import java.util.ResourceBundle;


public class ColumnController implements Initializable{

    private DefineBusinessRuleController defineBusinessRuleController;
    private Boolean meedereColumns;
    private boolean volgendeScene = true;

    @FXML
    public ChoiceBox<Column> columnBox1;

    @FXML
    public ChoiceBox<Column> columnBox2;

    @FXML
    private Text errorBox;

    public void fillColumns(List<Table> table, DefineBusinessRuleController defineBusinessRuleController){
        this.defineBusinessRuleController = defineBusinessRuleController;
        List<Column> allCollumns = defineBusinessRuleController.giveAllColumnsByTable(table.get(0));
        columnBox1.getItems().addAll(allCollumns);

        if (defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().toString().equals("TCMP")) {
            columnBox2.setVisible(true);
            columnBox2.getItems().addAll(allCollumns);
            meedereColumns = true;
        } else if (defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().toString().equals("ICMP")) {
            columnBox2.setVisible(true);
            List<Column> allCollumns2 = defineBusinessRuleController.giveAllColumnsByTable(table.get(1));
            columnBox2.getItems().addAll(allCollumns2);
            meedereColumns = true;
        } else {
            meedereColumns = false;
        }

    }


    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        List<Column> allColumns = new ArrayList<Column>() {};
        System.out.println(meedereColumns);
        // TODO foutmelding geen waarde geselecteerd
        if (columnBox1.getSelectionModel().getSelectedItem() == null) {
            volgendeScene = false;
            errorBox.setText("Er moet een selectie worden gemaakt");
        } else {
            volgendeScene = true;
            Column selectedColumn1 = columnBox1.getSelectionModel().getSelectedItem();
            if (meedereColumns) {
                // TODO foutmelding geen waarde geselecteerd
                if (columnBox2.getSelectionModel().getSelectedItem() == null) {
                    volgendeScene = false;
                    errorBox.setText("Er moet een selectie worden gemaakt");
                }  else {
                    Column selectedColumn2 = columnBox2.getSelectionModel().getSelectedItem();
                    allColumns.add(selectedColumn1);
                    allColumns.add(selectedColumn2);
                    volgendeScene = true;
                }


            } else {
                allColumns.add(selectedColumn1);
            }
            defineBusinessRuleController.setColumns(allColumns);
        }


        if ((defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().toString().equals("ARNG") || defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().toString().equals("ACMP")) && volgendeScene) {
            loader.setLocation(getClass().getResource("value.fxml"));
            Parent columnViewParent = loader.load();
            Scene columnViewScene = new Scene(columnViewParent);
            ValueController valueController = loader.getController();
            valueController.getValueTextVisible(defineBusinessRuleController);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(columnViewScene);
            window.show();
        } else if (volgendeScene) {
            loader.setLocation(getClass().getResource("operator.fxml"));
            Parent columnViewParent = loader.load();
            Scene columnViewScene = new Scene(columnViewParent);
            defineBusinessRuleController.setValueDefinition(null);
            OperatorController OperatorController = loader.getController();
            OperatorController.fillOperators(defineBusinessRuleController);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(columnViewScene);
            window.show();
        }

    }
}

