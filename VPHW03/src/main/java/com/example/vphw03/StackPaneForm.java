package com.example.vphw03;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class StackPaneForm extends Application {
    double sceneWidth = 320, sceneHeight = 240;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setStyle("-fx-background-color: white");
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        StackPane top = new StackPane();
        top.setPrefSize(sceneWidth - 10, sceneHeight/3);
        StackPane center = new StackPane();
        center.setPrefSize(sceneWidth - 10, sceneHeight/3);
        StackPane bottom = new StackPane();
        bottom.setPrefSize(sceneWidth - 10, sceneHeight/3);

        HBox hBoxLeft = new HBox();
        hBoxLeft.setStyle("-fx-border-color: black; -fx-border-radius: 3px;");
        hBoxLeft.setPrefSize(sceneWidth - 10, sceneHeight/3 - 3);
        HBox hBoxRight = new HBox();
        hBoxRight.setStyle("-fx-border-color: green; -fx-border-radius: 3px;");
        hBoxRight.setPrefSize(sceneWidth - 10, sceneHeight/3 - 3);
        HBox hBoxCenter = new HBox();
        hBoxCenter.setStyle("-fx-border-color: blue; -fx-border-radius: 3px;");
        hBoxCenter.setPrefSize(sceneWidth - 10, sceneHeight/3 - 3);

        Label labLeft = new Label("Left");
        labLeft.setPrefSize(50, 6);
        labLeft.setAlignment(Pos.CENTER);
        labLeft.setTranslateX(5);
        labLeft.setTranslateY(-8);
        labLeft.setStyle("-fx-background-color: white;");
        Label labRight = new Label("Right");
        labRight.setPrefSize(50, 6);
        labRight.setAlignment(Pos.CENTER);
        labRight.setTranslateX(-5);
        labRight.setTranslateY(-8);
        labRight.setStyle("-fx-background-color: white;");
        Label labCenter = new Label("Center");
        labCenter.setPrefSize(50, 6);
        labCenter.setAlignment(Pos.CENTER);
        labCenter.setTranslateX(0);
        labCenter.setTranslateY(-8);
        labCenter.setStyle("-fx-background-color: white;");

        top.getChildren().addAll(hBoxLeft, labLeft);
        top.setAlignment(labLeft, Pos.TOP_LEFT);
        top.setAlignment(hBoxLeft, Pos.BOTTOM_CENTER);
        center.getChildren().addAll(hBoxRight, labRight);
        center.setAlignment(labRight, Pos.TOP_RIGHT);
        center.setAlignment(hBoxRight, Pos.BOTTOM_CENTER);
        bottom.getChildren().addAll(hBoxCenter, labCenter );
        bottom.setAlignment(labCenter, Pos.TOP_CENTER);
        bottom.setAlignment(hBoxCenter, Pos.BOTTOM_CENTER);

        root.getChildren().addAll(top, center, bottom);
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        primaryStage.setTitle("Stack Pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
