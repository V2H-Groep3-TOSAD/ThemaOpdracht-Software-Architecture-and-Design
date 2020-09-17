package org.presentation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.BusinessRule;
import org.domain.BusinessRuleBuilder;
import org.domain.BusinessRuleType;
import org.domain.Operator;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class OperatorController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();
    private BusinessRuleBuilder businessRuleBuilder;

    @FXML
    public ChoiceBox<Operator> operatorChoiceBox;

    public void fillOperators(BusinessRuleBuilder businessRuleBuilder){
        this.businessRuleBuilder = businessRuleBuilder;

        List<Operator> operators = new ArrayList<>();
        BusinessRuleType businessRuleType = defineBusinessRuleController.giveBusinessRuleTypeByName(businessRuleBuilder.getBusinessRuleType().getName());

        for (Operator operator : businessRuleType.getOperators()) {
            operators.add(operator);
        }

        operatorChoiceBox.getItems().addAll(operators);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: 1-9-2020
    }



    public void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("overzicht.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);

//        BusinessRuleTypeOperator businessRuleTypeOperator = operatorChoiceBox.getSelectionModel().getSelectedItem();
        Operator operator = operatorChoiceBox.getSelectionModel().getSelectedItem();
        businessRuleBuilder.setOperator(operator);
        OverzichtController overzichtController = loader.getController();
        overzichtController.fillData(businessRuleBuilder);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }
}
