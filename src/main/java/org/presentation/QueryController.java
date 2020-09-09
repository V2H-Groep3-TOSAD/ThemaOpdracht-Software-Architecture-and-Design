package org.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.BusinessRule;
import org.domain.BusinessRuleType;
import org.generatemodule.businesslogic.controllers.GenerateBusinessRuleController;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class QueryController implements Initializable {

    private GenerateBusinessRuleController generateBusinessRuleController = new GenerateBusinessRuleController();
    private BusinessRule businessRule;

    @FXML
    private Text queryBox;

    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    public void fillQueryArea(BusinessRule businessRule){
        String templateCode = generateBusinessRuleController.generate(businessRule);
        queryBox.setText(templateCode);
        this.businessRule = businessRule;
    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("primary.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);

        generateBusinessRuleController.execute(businessRule.getName());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

}
