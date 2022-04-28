package com.example.vphw08withdb;

import com.example.vphw08withdb.DBHandler.DBUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

class MakeEditorStage{
    MakeEditorStage() throws IOException {
        Stage subStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("make-editor-pv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 100);
        subStage.setTitle("Make Editor");
        subStage.initStyle(StageStyle.UTILITY);
        subStage.setResizable(false);
        subStage.sizeToScene();
        subStage.setScene(scene);
        subStage.show();
    }
}

class ModelEditorStage{
    ModelEditorStage() throws IOException {
        Stage subStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("model-editor-pv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 100);
        subStage.setTitle("Model Editor");
        subStage.initStyle(StageStyle.UTILITY);
        subStage.setResizable(false);
        subStage.sizeToScene();
        subStage.setScene(scene);
        subStage.show();
    }
}

class ItemCategoryStage{
    ItemCategoryStage() throws IOException {
        Stage subStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("item-category-pv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 100);
        subStage.setTitle("Item Category Editor");
        subStage.initStyle(StageStyle.UTILITY);
        subStage.setResizable(false);
        subStage.sizeToScene();
        subStage.setScene(scene);
        subStage.show();
    }
}

class PartEditorStage{
    PartEditorStage() throws IOException {
        Stage subStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("part-editor-pv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 250);
        subStage.setTitle("Part Editor");
        subStage.initStyle(StageStyle.UTILITY);
        subStage.setResizable(false);
        subStage.sizeToScene();
        subStage.setScene(scene);
        subStage.show();
    }
}

class MainStage{
    MainStage() throws IOException {
        Stage mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-pv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 535);
        mainStage.setTitle("College Park Auto-Parts");
        mainStage.setResizable(false);
        mainStage.sizeToScene();
        mainStage.setScene(scene);
        mainStage.show();
    }
}

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        new DBUtil();
        new MainStage();
    }

    public static void main(String[] args) {
        launch();
    }
}