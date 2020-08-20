package org.openjfx;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

public class DatabaseController {

    @FXML
    private void nextKnopClick() throws IOException {
        App.setRoot("table");
    }
}
