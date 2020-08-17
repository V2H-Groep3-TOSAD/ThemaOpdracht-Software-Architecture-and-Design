package org.openjfx;

import java.io.IOException;

import javafx.fxml.FXML;
import org.services.PostgresServiceProvider;

public class PrimaryController {

    private PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");



    }
}
