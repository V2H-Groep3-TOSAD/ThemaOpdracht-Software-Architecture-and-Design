package org.openjfx;

import javafx.fxml.FXML;
import org.openjfx.App;

import java.io.IOException;

public class BusinessRuleTypeController {

    @FXML
    private void nextKnopClick() throws IOException {
        App.setRoot("operator");
    }
}
