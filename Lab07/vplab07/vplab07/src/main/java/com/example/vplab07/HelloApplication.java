package com.example.vplab07;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

class Child1{
    public String name = "Child1 Stage";
    Child1(String from){
        Stage subStage = new Stage();
        subStage.setTitle("Child1 Stage");
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        HBox labels = new HBox();
        Label lab = new Label("Hello from ");
        Label helloLab = new Label();
        helloLab.setText(from);
        labels.getChildren().addAll(lab, helloLab);
        HBox buttons = new HBox(10);
        buttons.setPadding(new Insets(5));
        Button btnBack = new Button("back");
        btnBack.setOnAction(event -> {
            new MainStage(name);
            subStage.close();
        });
        Button btnNext = new Button("next");
        btnNext.setOnAction(event -> {
            new Child2(name);
            subStage.hide();
        });
        buttons.getChildren().addAll(btnBack, btnNext);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().addAll(labels, buttons);
        Scene scene = new Scene(root, 240, 120);
        subStage.setScene(scene);
        subStage.show();
    }
}

class Child2{
    public String name = "Child2 Stage";
    Child2(String from){
        Stage subStage = new Stage();
        subStage.setTitle("Child2 Stage");
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        HBox labels = new HBox();
        Label lab = new Label("Hello from ");
        Label helloLab = new Label();
        helloLab.setText(from);
        labels.getChildren().addAll(lab, helloLab);
        HBox buttons = new HBox(10);
        buttons.setPadding(new Insets(5));
        Button btnBack = new Button("back");
        btnBack.setOnAction(event -> {
            new Child1(name);
            subStage.close();
        });
        buttons.getChildren().add(btnBack);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().addAll(labels, buttons);
        Scene scene = new Scene(root, 240, 120);
        subStage.setScene(scene);
        subStage.show();
    }
}

class MainStage{
    public String name = "Main Stage";
    MainStage(String from){
        Stage stage = new Stage();
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        HBox labels = new HBox();
        Label lab = new Label("Hello from ");
        Label helloLab = new Label();
        helloLab.setText(from);
        labels.getChildren().addAll(lab, helloLab);
        HBox buttons = new HBox(10);
        buttons.setPadding(new Insets(5));
        Button btnNext = new Button("next");
        btnNext.setOnAction(event -> {
            new Child1(name);
            stage.hide();
        });
        buttons.getChildren().add(btnNext);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().addAll(labels, buttons);
        Scene scene = new Scene(root, 240, 120);
        stage.setTitle("Main Stage");
        stage.setScene(scene);
        stage.show();
    }
}

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        new MainStage("");
    }

    public static void main(String[] args) {
        launch();
    }
}