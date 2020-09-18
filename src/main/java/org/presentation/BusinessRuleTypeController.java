package org.presentation;

import javafx.event.ActionEvent;
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
import org.application.domain.BusinessRule;
import org.application.domain.BusinessRuleType;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BusinessRuleTypeController implements Initializable {

    private  DefineBusinessRuleController defineController;

    @FXML
    private ChoiceBox<BusinessRuleType> businessRuleBox;

    @FXML
    private Text errorBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        defineController = new DefineBusinessRuleController();
        List<BusinessRuleType> allBusinessrulesTypes = defineController.giveAllBusinessRuleTypes();
        businessRuleBox.getItems().addAll(allBusinessrulesTypes);
    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("database.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);

        if (businessRuleBox.getSelectionModel().getSelectedItem() == null) {
            errorBox.setText("Er moet een selectie worden gemaakt");
        } else {
            BusinessRuleType businessRuleType = businessRuleBox.getSelectionModel().getSelectedItem();
            defineController.setBusinessRuleType(businessRuleType);
            DatabaseController databaseController = loader.getController();
            databaseController.fillDatabases(defineController);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }

    }
}

//public class BusinessRuleTypeController implements Initializable {
//
//    private DefineBusinessRuleController defineController = new DefineBusinessRuleController();
//    private static BusinessRuleBuilder businessRuleBuilder = new BusinessRuleBuilder();
//
//
//    @FXML
//    private ChoiceBox<BusinessRuleType> businessRuleBox;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        List<BusinessRuleType> allBusinessrulesTypes = defineController.giveAllBusinessRuleTypes();
//        businessRuleBox.getItems().addAll(allBusinessrulesTypes);
//    }
//
//    public void nextKnopClick(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("database.fxml"));
//        Parent tableViewParent = loader.load();
//        Scene tableViewScene = new Scene(tableViewParent);
//
//        BusinessRuleType businessRuleType = businessRuleBox.getSelectionModel().getSelectedItem();
//        businessRuleBuilder.setBusinessRuleType(businessRuleType);
//        DatabaseController databaseController = loader.getController();
//        databaseController.fillDatabases(businessRuleBuilder);
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(tableViewScene);
//        window.show();
//    }
//}

