package org.presentation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.application.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.application.domain.BusinessRuleTypeOperator;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OperatorController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController;

    @FXML
    public ChoiceBox<BusinessRuleTypeOperator> operatorChoiceBox;

    public void fillOperators(DefineBusinessRuleController defineBusinessRuleController){
        this.defineBusinessRuleController = defineBusinessRuleController;
        List<BusinessRuleTypeOperator> businessRuleTypeOperators = defineBusinessRuleController.giveAllOperatorsByBusinessRuleType(defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType());
        System.out.println(businessRuleTypeOperators);
        System.out.println(defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType());
        operatorChoiceBox.getItems().addAll(businessRuleTypeOperators);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("overzicht.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        //todo foutmelding geen waarde geselecteerd
        BusinessRuleTypeOperator businessRuleTypeOperator = operatorChoiceBox.getSelectionModel().getSelectedItem();
        defineBusinessRuleController.setOperator(businessRuleTypeOperator.getOperator());
        OverzichtController overzichtController = loader.getController();
        overzichtController.fillData(defineBusinessRuleController);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }
}

//public class OperatorController implements Initializable {
//
//    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();
//    private BusinessRuleBuilder businessRuleBuilder;
//
//    @FXML
//    public ChoiceBox<BusinessRuleTypeOperator> operatorChoiceBox;
//
//    public void fillOperators(BusinessRuleBuilder businessRuleBuilder){
//        this.businessRuleBuilder = businessRuleBuilder;
//
//        List<BusinessRuleTypeOperator> businessRuleTypeOperators = defineBusinessRuleController.giveAllOperatorsByBusinessRuleType(businessRuleBuilder.getBusinessRuleType());
//        System.out.println(businessRuleTypeOperators);
//        System.out.println(businessRuleBuilder.getBusinessRuleType());
//
//
//        operatorChoiceBox.getItems().addAll(businessRuleTypeOperators);
//
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        // TODO: 1-9-2020
//    }
//
//
//
//    public void nextKnopClick(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("overzicht.fxml"));
//        Parent tableViewParent = loader.load();
//        Scene tableViewScene = new Scene(tableViewParent);
//
//        BusinessRuleTypeOperator businessRuleTypeOperator = operatorChoiceBox.getSelectionModel().getSelectedItem();
//        businessRuleBuilder.setOperator(businessRuleTypeOperator.getOperator());
//        OverzichtController overzichtController = loader.getController();
//        overzichtController.fillData(businessRuleBuilder);
//
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(tableViewScene);
//        window.show();
//
//    }
//}
