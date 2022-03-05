package com.example.vplab02;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalculatorByTilepane extends Application {

    Button[] buttons = new Button[20];
    String[] labels = {"<- ", " C ", " % ", " + ", " 7 ", " 8 ", " 9 ", " - ", " 4 ", " 5 ", " 6 ", " * ", " 1 ", " 2 ", " 3 ", " / ", " 0 ", " . ", "-/+", " = "};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        double sceneWidth = 270, sceneHeight = 360;
        VBox root = new VBox();
        root.setPadding(new Insets(15));
        root.setSpacing(10);
        TextField tfInputNumber = new TextField();
        tfInputNumber.setAlignment(Pos.CENTER_RIGHT);
        tfInputNumber.setFont(Font.font(13));
        tfInputNumber.setPromptText("Enter only numbers!");
        TilePane inTilePane = new TilePane();
        for(int i = 0 ; i < 20; i++){
            buttons[i] = new Button(labels[i]);
            buttons[i].setPrefSize(50, 50);
        }

        inTilePane.getChildren().addAll(buttons);
        inTilePane.setPadding(new Insets(0));
        inTilePane.setHgap(12);
        inTilePane.setVgap(12);
        root.getChildren().addAll(tfInputNumber, inTilePane);
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}