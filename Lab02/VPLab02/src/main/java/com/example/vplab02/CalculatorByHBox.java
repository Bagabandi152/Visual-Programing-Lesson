package com.example.vplab02;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;

public class CalculatorByHBox extends Application {

    static Button[] buttons = new Button[20];
    static String[] labels = {
            "<- ", " C ", " % ", " + ",
            " 7 ", " 8 ", " 9 ", " - ",
            " 4 ", " 5 ", " 6 ", " * ",
            " 1 ", " 2 ", " 3 ", " / ",
            " 0 ", " . ", "-/+", " = "
    };

    double sceneWidth = 270, sceneHeight = 350;
    VBox root = new VBox();


    public static void getButtons(){
        for(int i = 0 ; i < 20; i++){
            buttons[i] = new Button(labels[i]);
            buttons[i].setPrefSize(50, 50);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        root.setPadding(new Insets(15));
        root.setSpacing(10);
        TextField tfInputNumber = new TextField();
        tfInputNumber.setAlignment(Pos.CENTER_RIGHT);
        tfInputNumber.setFont(Font.font(13));
        tfInputNumber.setPromptText("Enter only numbers!");

        getButtons();

        VBox inVBox = new VBox();
        inVBox.setSpacing(15);

        HBox[] rows = new HBox[20];
        for(int i = 0; i < 5; i++){
            rows[i] = new HBox(15);
            inVBox.getChildren().add(rows[i]);
        }

        for(int i = 0; i < 20; i++){
            rows[i/4].getChildren().add(buttons[i]);
        }

        root.getChildren().addAll(tfInputNumber, inVBox);
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}