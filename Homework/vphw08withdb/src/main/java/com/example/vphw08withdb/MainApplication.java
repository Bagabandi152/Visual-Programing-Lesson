package com.example.vphw08withdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

class MakeEditorStage{
    MakeEditorStage() throws IOException {
        Stage mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("make-editor-pv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 100);
        mainStage.setTitle("Make Editor");
        mainStage.setScene(scene);
        mainStage.show();
    }
}

class ModelEditorStage{
    ModelEditorStage() throws IOException {
        Stage mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("model-editor-pv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 100);
        mainStage.setTitle("Model Editor");
        mainStage.setScene(scene);
        mainStage.show();
    }
}

class ItemCategoryStage{
    ItemCategoryStage() throws IOException {
        Stage mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("item-category-pv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 100);
        mainStage.setTitle("Item Category Editor");
        mainStage.setScene(scene);
        mainStage.show();
    }
}



class PartEditorStage{
    PartEditorStage() throws IOException {
        Stage mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("part-editor-pv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 250);
        mainStage.setTitle("Part Editor");
        mainStage.setScene(scene);
        mainStage.show();
    }
}

class MainStage{
    MainStage() throws IOException {
        Stage mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-pv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 535);
        mainStage.setTitle("College Park Auto-Parts");
        mainStage.setScene(scene);
        mainStage.show();
    }
}

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new MainStage();
    }

    public static void main(String[] args) {
        launch();
    }
}