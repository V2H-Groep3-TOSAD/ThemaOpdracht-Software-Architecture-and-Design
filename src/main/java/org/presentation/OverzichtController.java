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
import org.application.domain.BusinessRuleBuilder;
import org.application.domain.Column;

import java.io.IOException;

public class OverzichtController {
    private BusinessRuleBuilder businessRuleBuilder;
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
    //labels vullen

    public void fillData(BusinessRuleBuilder businessRuleBuilder){
        this.businessRuleBuilder = businessRuleBuilder;
        databaseLabel.setText(businessRuleBuilder.getDatabase().getName());
        operatorLabel.setText(businessRuleBuilder.getOperator().getName());
//        valueLabel.setText(businessRuleBuilder.getValueDefinition().getLiteralValue());
        String colums = "";
        for(Column column : businessRuleBuilder.getAllColumns()){
            colums += column + " ";
        }
        columnLabel.setText(colums);
        tableLabel.setText(businessRuleBuilder.getTable().getName());
    }

    public void save(ActionEvent event) throws IOException{
        defineBusinessRuleController.saveBusinessRule(businessRuleBuilder);
    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("primary.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
}
