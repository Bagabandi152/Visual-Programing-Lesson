package com.example.stagedemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        StackPane root = new StackPane();
        List children = root.getChildren();

        double stageWidth = 500, stageHeight = 500;

        Line diaLine  = new Line(0, 0, stageWidth - 100, stageHeight - 100);

        Rectangle bigRect = new Rectangle(0, 0, stageWidth - 100, stageHeight - 100);
        bigRect.setStroke(Color.BLACK);
        bigRect.setFill(Color.TRANSPARENT);

        Rectangle smallRect = new Rectangle(0, 0, stageWidth - 130, stageHeight - 130);
        smallRect.setStroke(Color.BLACK);
        smallRect.setFill(Color.TRANSPARENT);

        Circle circle = new Circle(stageWidth/2 - 100, stageHeight/2 - 100, 100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.TRANSPARENT);

        children.add(diaLine);
        children.add(bigRect);
        children.add(smallRect);
        children.add(circle);

        stage.setTitle("My Shape");
        stage.setWidth(stageWidth);
        stage.setHeight(stageHeight);
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}