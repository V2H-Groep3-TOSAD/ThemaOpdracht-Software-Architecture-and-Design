package org.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.application.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.application.domain.BusinessRule;
import org.application.domain.Column;
import org.application.domain.Table;


import java.io.IOException;

public class OverzichtController {
    private DefineBusinessRuleController defineBusinessRuleController;

    @FXML
    private Label databaseLabel;

    @FXML
    private Label tableLabel;

    @FXML
    private Label columnLabel;

    @FXML
    private Label valueLabel;

    @FXML
    private Label operatorLabel;


    public void fillData(DefineBusinessRuleController defineBusinessRuleController){
        this.defineBusinessRuleController = defineBusinessRuleController;
        databaseLabel.setText(defineBusinessRuleController.getBusinessRuleBuilder().getDatabase().getName());
        operatorLabel.setText(defineBusinessRuleController.getBusinessRuleBuilder().getOperator().getName());
        System.out.println("dit: " +defineBusinessRuleController.getBusinessRuleBuilder().getValueDefinition());
        if(defineBusinessRuleController.getBusinessRuleBuilder().getValueDefinition() != null){
            valueLabel.setVisible(true);
            valueLabel.setText(defineBusinessRuleController.getBusinessRuleBuilder().getValueDefinition().toString());
        }
        String colums = "";
        for(Column column : defineBusinessRuleController.getColumns()){
            colums += column + " ";
        }
        columnLabel.setText(colums);
        String table = "";
        for(Table t : defineBusinessRuleController.getBusinessRuleBuilder().getTables()){
            table += t + " ";
        }
        tableLabel.setText(table);
    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        System.out.println(defineBusinessRuleController.getBusinessRuleBuilder());
        System.out.println(defineBusinessRuleController.getBusinessRuleBuilder().getValueDefinition());
        defineBusinessRuleController.generateBusinessRuleName();
        BusinessRule businessRule = defineBusinessRuleController.getBusinessRuleBuilder().build();
        defineBusinessRuleController.saveBusinessRule(businessRule);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("primary.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
}


