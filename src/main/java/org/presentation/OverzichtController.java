package org.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.definemodule.businesslogic.controllers.DefineBusinessRuleController;
import org.domain.BusinessRuleBuilder;
import org.domain.BusinessRuleType;

import java.io.IOException;

public class OverzichtController {
    private BusinessRuleBuilder businessRuleBuilder;
    private DefineBusinessRuleController defineBusinessRuleController;

    //labels vullen

    public void fillData(BusinessRuleBuilder businessRuleBuilder){
        this.businessRuleBuilder = businessRuleBuilder;
        //labels vullen data
    }

    public void save(ActionEvent event) throws IOException{
        defineBusinessRuleController.saveBusinessRule(businessRuleBuilder);
    }

    public void nextKnopClick(ActionEvent event) throws IOException {
        //terug naar hoofdmenu 
    }
}
