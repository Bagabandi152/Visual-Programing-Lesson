package com.example.vplab02;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class FormHW extends Application {

    static String[] formFieldLabels = {"Firstname", "Lastname", "Birthdate", "Higher education", "Age", "SSN", "Remark"};
    static String[] defaultValues = {"John", "Smith", "3/21/1973", "true", "34", "1234567890", ""};
    static String[] btnLabels = {"Accept", "Cancel"};

    static double sceneWidth = 400, sceneHeight = 305, rootPadding = 15;
    static int fieldCnt = 7;

    public static void main(String[] args) {
        launch(args);
    }

    public static VBox getContent(){
        VBox invBox = new VBox();
        for(int i = 0; i < fieldCnt; i++){
            HBox tmpHBox = new HBox();
            if(i == 2){
                Label label = new Label(formFieldLabels[i]);
                label.setPrefWidth((sceneWidth - rootPadding)*0.4);
                DatePicker field = new DatePicker();
                field.setPrefWidth((sceneWidth - rootPadding)*0.6);
                field.setPromptText(defaultValues[i]);
                tmpHBox.getChildren().addAll(label, field);
            }else if(i == 3){
                Label label = new Label(formFieldLabels[i]);
                label.setPrefWidth((sceneWidth - rootPadding)*0.4);
                CheckBox field = new CheckBox();
                field.setPrefWidth((sceneWidth - rootPadding)*0.6);
                field.setSelected(true);
                tmpHBox.getChildren().addAll(label, field);
            }else if(i == 6){
                Label label = new Label(formFieldLabels[i]);
                label.setPrefWidth((sceneWidth - rootPadding)*0.4);
                TextArea field = new TextArea();
                field.setPrefWidth((sceneWidth - rootPadding)*0.6);
                field.setText(defaultValues[i]);
                tmpHBox.getChildren().addAll(label, field);
            }else{
                Label label = new Label(formFieldLabels[i]);
                label.setPrefWidth((sceneWidth - rootPadding)*0.4);
                TextField field = new TextField();
                field.setPrefWidth((sceneWidth - rootPadding)*0.6);
                field.setText(defaultValues[i]);
                tmpHBox.getChildren().addAll(label, field);
            }
            invBox.setSpacing(10);
            invBox.setPadding(new Insets(0));
            invBox.getChildren().add(tmpHBox);
        }

        return invBox;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setPadding(new Insets(rootPadding));

        Button acceptBtn = new Button(btnLabels[0]);
        acceptBtn.setPrefWidth((sceneWidth - rootPadding)*0.6/2 - 10);
        acceptBtn.setPadding(new Insets(5, 0 , 5, 0));
        Button cancelBtn = new Button(btnLabels[1]);
        cancelBtn.setPrefWidth((sceneWidth - rootPadding)*0.6/2 - 10);
        cancelBtn.setPadding(new Insets(5, 0 , 5, 0));

        HBox bottomRow = new HBox();
        bottomRow.setMaxWidth(sceneWidth - rootPadding);
        bottomRow.setSpacing(10);
        bottomRow.setPadding(new Insets(10, 0, 0, 0));
        bottomRow.setAlignment(Pos.CENTER_RIGHT);
        bottomRow.getChildren().addAll(acceptBtn, cancelBtn);

        root.getChildren().addAll(getContent(), bottomRow);
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        primaryStage.setTitle("");//FORM
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
