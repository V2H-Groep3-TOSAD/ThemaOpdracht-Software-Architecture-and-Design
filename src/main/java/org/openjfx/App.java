package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.definemodule.businesslogic.services.postgresservice.PostgresServiceProvider;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        PostgresServiceProvider postgresServiceProvider = new PostgresServiceProvider();
        TableController tableController = new TableController();
        String message = "dniudnjldndl";
        //List<Database> databases = postgresServiceProvider.getDatabasePostgresService().getDatabaseByName(message);
        //Database database = databases.get(0);

        //System.out.println(database.getName());

        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(org.openjfx.App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        launch();
    }

}