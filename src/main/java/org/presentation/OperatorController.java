package org.presentation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.application.definemodule.businesslogic.controllers.DefineBusinessRuleController;

import javafx.event.ActionEvent;
import org.application.domain.BusinessRuleType;
import org.application.domain.Operator;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OperatorController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController;

    @FXML
    public ChoiceBox<Operator> operatorChoiceBox;

    @FXML
    private Text errorBox;

    public void fillOperators(DefineBusinessRuleController defineBusinessRuleController){
//        this.businessRuleBuilder = businessRuleBuilder;

        this.defineBusinessRuleController = defineBusinessRuleController;

        List<Operator> operators = new ArrayList<>();
//        List<Operator> operators = defineBusinessRuleController.giveAllOperatorsByBusinessRuleType(defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType());

        BusinessRuleType businessRuleType = defineBusinessRuleController.giveBusinessRuleTypeByName(defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType().getName());

        for (Operator operator : businessRuleType.getOperators()) {
            operators.add(operator);
        }

        operatorChoiceBox.getItems().addAll(operators);

//        System.out.println(businessRuleTypeOperators);
//        System.out.println(defineBusinessRuleController.getBusinessRuleBuilder().getBusinessRuleType());
//        operatorChoiceBox.getItems().addAll(businessRuleTypeOperators);
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
        if (operatorChoiceBox.getSelectionModel().getSelectedItem() == null) {
            errorBox.setText("Er moet een selectie worden gemaakt");
        } else {
            Operator operator = operatorChoiceBox.getSelectionModel().getSelectedItem();
            defineBusinessRuleController.setOperator(operator);
            OverzichtController overzichtController = loader.getController();
            overzichtController.fillData(defineBusinessRuleController);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }


    }
}

