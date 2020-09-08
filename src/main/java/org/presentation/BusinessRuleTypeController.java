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
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.BusinessRuleBuilder;
import org.domain.BusinessRuleType;
import org.domain.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BusinessRuleTypeController implements Initializable {

    private DefineBusinessRuleController defineController = new DefineBusinessRuleController();
    private static BusinessRuleBuilder businessRuleBuilder = new BusinessRuleBuilder();


    @FXML
    private ChoiceBox<BusinessRuleType> businessRuleBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<BusinessRuleType> allBusinessrulesTypes = defineController.giveAllBusinessRuleTypes();
        businessRuleBox.getItems().addAll(allBusinessrulesTypes);
    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("database.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);

        BusinessRuleType businessRuleType = businessRuleBox.getSelectionModel().getSelectedItem();
        businessRuleBuilder.setBusinessRuleType(businessRuleType);
        DatabaseController databaseController = loader.getController();
        databaseController.fillDatabases(businessRuleBuilder);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
}
