package org.presentation;

import javafx.fxml.FXML;

import java.io.IOException;

public class CategoryController {

    @FXML
    private void nextKnopClick() throws IOException {
        App.setRoot("businessRuleType");
    }
}
