package org.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.BusinessRuleBuilder;
import org.domain.BusinessRuleType;

import java.io.IOException;

public class OverzichtController {
    private BusinessRuleBuilder businessRuleBuilder;
    private DefineBusinessRuleController defineBusinessRuleController;

    //labels vullen
    @FXML
    public Label databaseLabel;
    @FXML
    public Label tableLabel;
    @FXML
    public Label columnLabel;
    @FXML
    public Label valueLabel;
    @FXML
    public Label operatorLabel;

    public void fillData(BusinessRuleBuilder businessRuleBuilder){
        this.businessRuleBuilder = businessRuleBuilder;
        //labels vullen data
        databaseLabel.setText(businessRuleBuilder.getDatabase().toString());
        tableLabel.setText(businessRuleBuilder.getTable().toString());
        columnLabel.setText(businessRuleBuilder.getAllColumns().toString());

        operatorLabel.setText(businessRuleBuilder.getOperator().toString());
    }

    public void save(ActionEvent event) throws IOException{
        defineBusinessRuleController.saveBusinessRule(businessRuleBuilder);
    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        //terug naar hoofdmenu 
    }
}
