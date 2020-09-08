package org.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ColumnController {

    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();

    @FXML
    public ChoiceBox<Column> columnBox;

    public void fillColumns(Table table, BusinessRuleBuilder businessRuleBuilder){
        businessRuleBuilder.setTable(table);
        List<Column> allCollumns = defineBusinessRuleController.giveAllColumnsByTable(table);
        columnBox.getItems().addAll((Column) allCollumns);
    }


    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void nextKnopClick() throws IOException {
        //
    }
}