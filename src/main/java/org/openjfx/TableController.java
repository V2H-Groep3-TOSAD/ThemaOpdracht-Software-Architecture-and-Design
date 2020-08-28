package org.openjfx;

import javafx.fxml.FXML;

import java.io.IOException;

public class TableController {

    @FXML
    private void nextKnopClick() throws IOException {
        App.setRoot("column");
    }
}
