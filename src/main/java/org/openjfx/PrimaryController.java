package org.openjfx;

import java.io.IOException;

import javafx.fxml.FXML;
import org.services.PostgresServiceProvider;

public class PrimaryController {

    private PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();

    @FXML
    private void switchToDefine() throws IOException {
        App.setRoot("database");
    }
    @FXML
    private void switchToGenerate() throws IOException {
        App.setRoot("generate");
    }
}
