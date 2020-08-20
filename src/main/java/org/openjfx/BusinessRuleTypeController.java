package org.openjfx;

import javafx.fxml.FXML;

import java.io.IOException;

public class BusinessRuleTypeController {

    @FXML
    private void nextKnopClick() throws IOException {
        App.setRoot("operator");
    }
}
