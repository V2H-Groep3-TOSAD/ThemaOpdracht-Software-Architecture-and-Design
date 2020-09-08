package org.presentation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.BusinessRuleBuilder;
import org.domain.BusinessRuleType;
import org.domain.BusinessRuleTypeOperator;
import org.domain.Operator;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OperatorController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();
    private BusinessRuleBuilder businessRuleBuilder;

    @FXML
    public ChoiceBox<BusinessRuleTypeOperator> operatorChoiceBox;

    public void fillOperators(BusinessRuleBuilder businessRuleBuilder){
        List<BusinessRuleTypeOperator> businessRuleTypeOperators = defineBusinessRuleController.giveAllBusinessRuleTypeOperators(businessRuleBuilder.getBusinessRuleType());
        operatorChoiceBox.getItems().addAll(businessRuleTypeOperators);
        this.businessRuleBuilder = businessRuleBuilder;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: 1-9-2020
    }



    private void nextKnopClick() throws IOException {
        App.setRoot("operator");
    }
}
