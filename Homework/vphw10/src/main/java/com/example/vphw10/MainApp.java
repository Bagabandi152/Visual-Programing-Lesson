package com.example.vphw10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Bagaa
 * @project vphw10
 * @created 10/05/2022 - 8:03 PM
 */

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("threads.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 380, 524);
        primaryStage.setTitle("Threads and GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
