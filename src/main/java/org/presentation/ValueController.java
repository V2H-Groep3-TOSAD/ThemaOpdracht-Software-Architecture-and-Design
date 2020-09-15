package org.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.BusinessRuleBuilder;
import org.domain.Table;
import org.domain.ValueDefinition;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ValueController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController;
    private BusinessRuleBuilder businessRuleBuilder;
    private ValueDefinition value;

    @FXML
    public TextField valueText1;

    @FXML
    public TextField valueText2;

    public void setBusinessRuleBuilder(BusinessRuleBuilder businessRuleBuilder){
        this.businessRuleBuilder = businessRuleBuilder;

        if (businessRuleBuilder.getBusinessRuleType().toString().equals("ARNG")) {
            valueText2.setVisible(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("operator.fxml"));
        Parent columnViewParent = loader.load();
        Scene columnViewScene = new Scene(columnViewParent);

        if (businessRuleBuilder.getBusinessRuleType().toString().equals("ARNG")) {
            value = new ValueDefinition(Integer.parseInt(valueText1.getText()),Integer.parseInt(valueText2.getText()),null);
        }

        if (businessRuleBuilder.getBusinessRuleType().toString().equals("ACMP")) {
            value = new ValueDefinition(valueText1.getText());
        }

        businessRuleBuilder.setValueDefinition(value);

        //get values from inputfield
        ValueDefinition valueDefinition = new ValueDefinition();
        valueDefinition.setLiteralValue(valueText1.getText());
        //set andere waardes
        defineBusinessRuleController.saveValueDef(valueDefinition);
        businessRuleBuilder.setValueDefinition(valueDefinition);
        //set builder with values
        //operatorcontroller aanroepen met businessrulebuilder type
        OperatorController operatorController = loader.getController();
        operatorController.fillOperators(businessRuleBuilder);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(columnViewScene);
        window.show();
    }
}
