package org.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.application.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.application.domain.BusinessRule;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GenerateController implements Initializable {

    private DefineBusinessRuleController defineBusinessRuleController = new DefineBusinessRuleController();

    @FXML
    private ChoiceBox<BusinessRule> businessRulesBox;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        List<BusinessRule> allBusinessRules = defineBusinessRuleController.giveAllBusinessRules();
        businessRulesBox.getItems().addAll(allBusinessRules);
    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("query.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);

        BusinessRule businessRule = businessRulesBox.getSelectionModel().getSelectedItem();
        QueryController queryController = loader.getController();
        System.out.println(businessRule.getColumns());
        queryController.fillQueryArea(businessRule);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


}
