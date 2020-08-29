package org.openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.openjfx.App;

import java.io.IOException;

public class DefineController {

    public ComboBox businessRuleType;

    @FXML
    private void volgendeKnopClick() throws IOException {
        if (businessRuleType.getValue().toString().equals("Range")) {
            App.setRoot("range");
        }
    }
}
