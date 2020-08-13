package org.openjfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {
    @FXML
    private void switchToDefine() throws IOException {
        App.setRoot("define");
    }
    @FXML
    private void switchToGenerate() throws IOException {
        App.setRoot("generate");
    }
}
