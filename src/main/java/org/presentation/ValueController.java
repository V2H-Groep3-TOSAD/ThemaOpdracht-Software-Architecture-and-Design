package org.presentation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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

    @FXML
    private Text errorBox;

    @FXML
    private Label valueText;

    public void getValueTextVisible(DefineBusinessRuleController defineBusinessRuleController){
        this.defineBusinessRuleController = defineBusinessRuleController;
        valueText.setText("Value: " + defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().getName());

        if (defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().getName().equals("ARNG")) {
            valueText2.setVisible(true);

            valueText.setText("Value: " + defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().getName());

            valueText1.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        valueText1.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });

            valueText2.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        valueText2.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        }

        System.out.println(defineBusinessRuleController.getBusinessRuleBuilder().getColumns().get(0));
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
            System.out.println("dit: " + valueText1.getText());
            if (valueText1.getText().trim().isEmpty() || valueText2.getText().trim().isEmpty()) {
                errorBox.setText("Er moet een selectie worden gemaakt");
            } else {
                ValueDefinition value = new ValueDefinition(Integer.parseInt(valueText1.getText()),Integer.parseInt(valueText2.getText()),null);
                defineBusinessRuleController.saveValueDef(value);
                List<ValueDefinition> valueDefinitions = defineBusinessRuleController.getValueDefinitions();
                ValueDefinition valWithId = valueDefinitions.get(valueDefinitions.size()-1);
                defineBusinessRuleController.setValueDefinition(valWithId);

                OperatorController operatorController = loader.getController();
                operatorController.fillOperators(defineBusinessRuleController);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(columnViewScene);
                window.show();
            }

        }

        if (defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().toString().equals("ACMP")) {
            //TODO fourmelding geen input
            if (valueText1.getText().trim().isEmpty()) {
                errorBox.setText("Er moet een selectie worden gemaakt");
            } else {
                //TODO label acmp
                //todo input waarde afhankelijk van datatype kolom
                ValueDefinition value = new ValueDefinition(valueText1.getText());
                //System.out.println( defineBusinessRuleController.getValueDefinitions());
                defineBusinessRuleController.saveValueDef(value);
                List<ValueDefinition> valueDefinitions = defineBusinessRuleController.getValueDefinitions();
                ValueDefinition valWithId = valueDefinitions.get(valueDefinitions.size()-1);
                defineBusinessRuleController.setValueDefinition(valWithId);

                OperatorController operatorController = loader.getController();
                operatorController.fillOperators(defineBusinessRuleController);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(columnViewScene);
                window.show();
            }

        }


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
