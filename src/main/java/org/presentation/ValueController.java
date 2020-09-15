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
import org.application.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.application.domain.BusinessRule;
import org.application.domain.ValueDefinition;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ValueController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController;

    @FXML
    public TextField valueText1;

    @FXML
    public TextField valueText2;

    public void getValueTextVisible(DefineBusinessRuleController defineBusinessRuleController){
        this.defineBusinessRuleController = defineBusinessRuleController;
        if (defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().getName().equals("ARNG")) {
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

        if (defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().toString().equals("ARNG")) {
            //TODO input waardes zijn nummers
            //TODO foutmelding geen input
            //TODO label arng
            ValueDefinition value = new ValueDefinition(Integer.parseInt(valueText1.getText()),Integer.parseInt(valueText2.getText()),null);
            defineBusinessRuleController.saveValueDef(value);
            List<ValueDefinition> valueDefinitions = defineBusinessRuleController.getValueDefinitions();
            ValueDefinition valWithId = valueDefinitions.get(valueDefinitions.size()-1);
            defineBusinessRuleController.setValueDefinition(valWithId);
        }

        if (defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().toString().equals("ACMP")) {
            //TODO fourmelding geen input
            //TODO label acmp
            //todo input waarde afhankelijk van datatype kolom
            ValueDefinition value = new ValueDefinition(valueText1.getText());
            //System.out.println( defineBusinessRuleController.getValueDefinitions());
            defineBusinessRuleController.saveValueDef(value);
            List<ValueDefinition> valueDefinitions = defineBusinessRuleController.getValueDefinitions();
            ValueDefinition valWithId = valueDefinitions.get(valueDefinitions.size()-1);
            defineBusinessRuleController.setValueDefinition(valWithId);
        }

        OperatorController operatorController = loader.getController();
        operatorController.fillOperators(defineBusinessRuleController);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(columnViewScene);
        window.show();
    }
}


//public class ValueController implements Initializable {
//
//    private DefineBusinessRuleController defineBusinessRuleController;
//    private BusinessRuleBuilder businessRuleBuilder;
//    private ValueDefinition value;
//
//    @FXML
//    public TextField valueText1;
//
//    @FXML
//    public TextField valueText2;
//
//    public void setBusinessRuleBuilder(BusinessRuleBuilder businessRuleBuilder){
//        this.businessRuleBuilder = businessRuleBuilder;
//
//        if (businessRuleBuilder.getBusinessRuleType().toString().equals("ARNG")) {
//            valueText2.setVisible(true);
//        }
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
//
//    public void nextKnopClick(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("operator.fxml"));
//        Parent columnViewParent = loader.load();
//        Scene columnViewScene = new Scene(columnViewParent);
//
//        if (businessRuleBuilder.getBusinessRuleType().toString().equals("ARNG")) {
//            value = new ValueDefinition(Integer.parseInt(valueText1.getText()),Integer.parseInt(valueText2.getText()),null);
//        }
//
//        if (businessRuleBuilder.getBusinessRuleType().toString().equals("ACMP")) {
//            value = new ValueDefinition(valueText1.getText());
//        }
//
//        businessRuleBuilder.setValueDefinition(value);
//
//        //get values from inputfield
//        ValueDefinition valueDefinition = new ValueDefinition();
//        valueDefinition.setLiteralValue(valueText1.getText());
//        //set andere waardes
//        defineBusinessRuleController.saveValueDef(valueDefinition);
//        businessRuleBuilder.setValueDefinition(valueDefinition);
//        //set builder with values
//        //operatorcontroller aanroepen met businessrulebuilder type
//        OperatorController operatorController = loader.getController();
//        operatorController.fillOperators(businessRuleBuilder);
//
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(columnViewScene);
//        window.show();
//    }
//}
