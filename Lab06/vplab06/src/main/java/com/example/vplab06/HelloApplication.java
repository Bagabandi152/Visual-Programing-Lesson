package com.example.vplab06;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Observable Lists Demo");
        Group root = new Group();
        Scene scene = new Scene(root, 430, 350, Color.WHITE);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        Label candidatesLbl = new Label("Hidden");
        GridPane.setHalignment(candidatesLbl, HPos.CENTER);
        gridpane.add(candidatesLbl, 0, 0);
        Label heroesLbl = new Label("Visible");
        gridpane.add(heroesLbl, 2, 0);
        GridPane.setHalignment(heroesLbl, HPos.CENTER);
        final ObservableList<MountainName> candidates = FXCollections.observableArrayList(
                new MountainName(0, "Mount Everest"),
                new MountainName(1,"K2"),
                new MountainName(2,"Kangchenjunga"),
                new MountainName(3,"Lhotse"),
                new MountainName(4,"Cho Oyu"),
                new MountainName(5,"Manaslu"),
                new MountainName(6,"Nanga Parbat"),
                new MountainName(7,"Makalu"),
                new MountainName(8,"Mount Kilimanjaro"),
                new MountainName(9,"Aconcagua"),
                new MountainName(10,"Denali"),
                new MountainName(11,"Mount Elbrus"));
        final ListView<MountainName> candidatesListView = new ListView<>(candidates);
        candidatesListView.setCellFactory(param -> new ListCell<MountainName>() {
            @Override
            protected void updateItem(MountainName item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });
        candidatesListView.setPrefWidth(150);
        candidatesListView.setPrefHeight(150);
        gridpane.add(candidatesListView, 0, 1);
        final ObservableList<MountainName> heroes = FXCollections.observableArrayList();
        final ListView<MountainName> heroListView = new ListView<>(heroes);
        heroListView.setCellFactory(param -> new ListCell<MountainName>() {
            @Override
            protected void updateItem(MountainName item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });
        heroListView.setPrefWidth(150);
        heroListView.setPrefHeight(150);
        gridpane.add(heroListView, 2, 1);
        Button sendRightButton = new Button("Add >");
        sendRightButton.setPrefWidth(100);
        sendRightButton.setOnAction((e) -> {
            MountainName potential = candidatesListView.getSelectionModel().getSelectedItem();
            if (potential != null) {
                candidatesListView.getSelectionModel().clearSelection();
                candidates.remove(potential);
                heroes.add(potential);
            }
        });
        Button sendRightAllButton = new Button("Add all >>");
        sendRightAllButton.setPrefWidth(100);
        sendRightAllButton.setOnAction((e) -> {
            ObservableList<MountainName> potential = candidatesListView.getItems();
            if (potential != null) {
                candidatesListView.getSelectionModel().clearSelection();
                heroes.addAll(potential);
                candidates.removeAll(potential);
            }
        });
        Button sendLeftButton = new Button("< Remove");
        sendLeftButton.setPrefWidth(100);
        sendLeftButton.setOnAction((e) -> {
            MountainName notHero = heroListView.getSelectionModel().getSelectedItem();
            if (notHero != null) {
                heroListView.getSelectionModel().clearSelection();
                heroes.remove(notHero);
                candidates.add(notHero);
            }
        });
        Button sendLeftAllButton = new Button("<< Remove all");
        sendLeftAllButton.setPrefWidth(100);
        sendLeftAllButton.setOnAction((e) -> {
            ObservableList<MountainName> notHero = heroListView.getItems();
            if (notHero != null) {
                heroListView.getSelectionModel().clearSelection();
                candidates.addAll(notHero);
                heroes.removeAll(notHero);
            }
        });

        ImageView imageView = new ImageView();
        heroListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MountainName>() {
            @Override
            public void changed(ObservableValue<? extends MountainName> observable, MountainName oldValue, MountainName newValue) {
                InputStream path;
                try {
                    path = new FileInputStream("src\\main\\resources\\com\\example\\vplab06\\images\\" + newValue.getKey() + ".PNG");
                } catch (FileNotFoundException err) {
                    err.printStackTrace();
                    return;
                }
                imageView.setImage(new Image(path));
            }
        });
        gridpane.add(imageView, 2, 2);
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(sendRightButton,sendRightAllButton,sendLeftButton,sendLeftAllButton);
        gridpane.add(vbox, 1, 1);
        GridPane.setConstraints(vbox, 1, 1, 1, 2,HPos.CENTER, VPos.CENTER);
        root.getChildren().add(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}