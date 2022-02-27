package com.example.vplab03;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    String[] labels = {"a: ", "b: ", "c: "};
    double sceneWidth = 230, sceneHeight = 245;
    static List<TextField> fields = new ArrayList<>();
    static List<TextField> ans = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        root.setSpacing(10);
        VBox inVbox = new VBox();
        inVbox.setSpacing(10);
        inVbox.setPadding(new Insets(10));
        for(int i = 0; i < 3; i++){
            HBox tmp = new HBox();
            tmp.setPrefWidth(sceneWidth);
            Label lab = new Label(labels[i]);
            lab.setPrefWidth(sceneWidth*0.2);
            TextField field = new TextField();
            fields.add(field);
            field.setPrefWidth(sceneWidth*0.8);
            tmp.getChildren().addAll(lab, field);
            tmp.setSpacing(5);
            inVbox.getChildren().add(tmp);
        }
        BorderPane inBorder = new BorderPane();
        Button solve = new Button("Solve");
        solve.setOnAction(e -> {
            String[] x = new String[3];
            int i;
            for(i = 0; i < 3; i++){
                x[i] = (fields.get(i).getText().trim());
            }

            double a, b, c;

            if (x[0] == null || x[1] == null || x[2] == null) {
                return;
            }

            try {
                a = Double.parseDouble(x[0]);
            } catch (NumberFormatException err) {
                fields.get(0).setStyle("-fx-background-color: rgba(255, 0, 0, 0.3);");
                return;
            }

            try {
                b = Double.parseDouble(x[1]);
            } catch (NumberFormatException err) {
                fields.get(1).setStyle("-fx-background-color: rgba(255, 0, 0, 0.3);");
                return;
            }

            try {
                c = Double.parseDouble(x[2]);
            } catch (NumberFormatException err) {
                fields.get(2).setStyle("-fx-background-color: rgba(255, 0, 0, 0.3);");
                return;
            }

            double desc = b*b - 4*a*c;
            if(desc == 0){
                double x1 = -1*b/(2*a);
                ans.get(0).setText(Double.toString(x1));
            }else if(desc > 0){
                double x1 = (-1*b + Math.sqrt(desc))/2*a;
                double x2 = (-1*b - Math.sqrt(desc))/2*a;
                ans.get(0).setText(Double.toString(x1));
                ans.get(1).setText(Double.toString(x2));
            }else{
                System.out.println("No solution!");
            }
        });
        inBorder.setTop(solve);
        BorderPane.setAlignment(solve, Pos.CENTER);
        HBox inBorderHbox = new HBox();
        inBorderHbox.setSpacing(10);
        inBorderHbox.setPadding(new Insets(10));
        inBorderHbox.setAlignment(Pos.CENTER);
        for(int i = 0; i < 2; i++){
            HBox tmp = new HBox();
            tmp.setPrefWidth(sceneWidth-20);
            String txt = "x" + (i + 1) + ":";
            Label lab = new Label(txt);
            lab.setPrefWidth(((sceneWidth-20)/2)*0.3);
            TextField field = new TextField();
            field.setPrefWidth(((sceneWidth-20)/2)*0.7);
            ans.add(field);
            tmp.getChildren().addAll(lab, field);
            tmp.setSpacing(2);
            inBorderHbox.getChildren().addAll(lab, field);
        }
        inBorder.setCenter(inBorderHbox);
        BorderPane.setAlignment(solve, Pos.CENTER);
        Button close = new Button("Close");
        close.setOnAction(e -> {
//            Platform.exit();
            stage.close();
        });
        inBorder.setBottom(close);
        BorderPane.setAlignment(close, Pos.CENTER);
        root.getChildren().addAll(inVbox, new Separator(), inBorder);
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        stage.setTitle("Square Question Solution");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}