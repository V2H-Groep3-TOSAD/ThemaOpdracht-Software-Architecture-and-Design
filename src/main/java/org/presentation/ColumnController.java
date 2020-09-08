package org.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

import javafx.stage.Stage;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.Table;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ColumnController implements Initializable{

    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();
    private BusinessRuleBuilder businessRuleBuilder;

    @FXML
    public ChoiceBox<Column> columnBox;

    public void fillColumns(Table table, BusinessRuleBuilder businessRuleBuilder){
        this.businessRuleBuilder = businessRuleBuilder;
        businessRuleBuilder.setTable(table);
        System.out.println(businessRuleBuilder);
        List<Column> allCollumns = defineBusinessRuleController.giveAllColumnsByTable(table);
        columnBox.getItems().addAll(allCollumns);
    }


    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        //if type is dan value fxml voor businessrule met meerdere inputvelden
        //else 1 inputveld
        loader.setLocation(getClass().getResource("value.fxml"));
        Parent columnViewParent = loader.load();
        Scene columnViewScene = new Scene(columnViewParent);

        //all kolommen toevoegen aan businessrulebuilder
        Column selectedColumn = columnBox.getSelectionModel().getSelectedItem();
        List<Column> allColumns = new ArrayList<Column>() {
        };
        allColumns.add(selectedColumn);
        businessRuleBuilder.setAllColumns(allColumns);
        ValueController valueController = loader.getController();
        valueController.setBusinessRuleBuilder(businessRuleBuilder);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(columnViewScene);
        window.show();
    }
}