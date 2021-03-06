package com.example.vphw03;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    double sceneWidth = 540, sceneHeight = 320;
    static String[] labels = {"Book Title: ", "ISBN (Identifier): ", "Price: ", "Quantity: ", "Subtotal: ", "Sales Tax: ", "Total Due: "};
    static String[] defaultValue = {"", "", "$0.00", "0", "$0.00", "$0.00", "$0.00"};
    static String[] btnLabels = {"Compute", "Reset", "Totals", "Exit"};
    static List<TextField> fields = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #FFE1B5; -fx-font-weight: bold; -fx-font-size: 10pt;");
        root.setSpacing(8);
        root.setPadding(new Insets(10));

        StackPane fieldSection = new StackPane();
        fieldSection.setMaxWidth(sceneWidth - 20);

        Label labLeft = new Label("Textbook Sale Information");
        labLeft.setPrefSize(171, 6);
        labLeft.setAlignment(Pos.CENTER);
        labLeft.setTranslateX(5);
        labLeft.setTranslateY(-8);
        labLeft.setStyle("-fx-background-color: #FFE1B5;");

        VBox fieldContent = getFieldContent();
        fieldContent.setStyle("-fx-border-color: #f2f3f4; -fx-border-width: 2px; -fx-border-radius: 3px;");
        fieldContent.setPrefWidth(sceneWidth - 20);

        fieldSection.getChildren().addAll(fieldContent, labLeft);
        fieldSection.setAlignment(labLeft, Pos.TOP_LEFT);
        fieldSection.setAlignment(fieldContent, Pos.BOTTOM_CENTER);

        HBox buttons = getButtons();
        root.getChildren().addAll(fieldSection, buttons);
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        stage.setTitle("VB University - Book Store");
        stage.setScene(scene);
        stage.show();
    }


    public VBox getFieldContent(){
        VBox resVbox = new VBox();
        resVbox.setSpacing(5);
        resVbox.setPrefWidth(sceneWidth - 20);
        resVbox.setPadding(new Insets(15, 5, 15,5));

        ObservableList<Node> child = resVbox.getChildren();
        for(int i = 0; i < labels.length; i++){
            HBox tmpHbox = new HBox();
            tmpHbox.setAlignment(Pos.CENTER_LEFT);
            tmpHbox.setSpacing(5);
            if(i == 0){
                Label lab = new Label();
                lab.setPrefWidth((sceneWidth - 40)*0.24);
                lab.setText(labels[i]);
                TextField tf = new TextField();
                tf.setText(defaultValue[i]);
                fields.add(tf);
                tf.setPrefWidth((sceneWidth - 40)*0.76);
                tmpHbox.getChildren().addAll(lab, tf);
            }else if(i == 1){
                Label lab = new Label();
                lab.setPrefWidth((sceneWidth - 40)*0.24);
                lab.setText(labels[i]);
                TextField tf = new TextField();
                tf.setText(defaultValue[i]);
                fields.add(tf);
                tf.setPrefWidth((sceneWidth - 40)*0.45);
                tmpHbox.getChildren().addAll(lab, tf);
            }else{
                Label lab = new Label();
                lab.setPrefWidth((sceneWidth - 40)*0.24);
                lab.setText(labels[i]);
                TextField tf = new TextField();
                tf.setText(defaultValue[i]);
                if(i > 3){
                    tf.setDisable(true);
                }
                fields.add(tf);
                tf.setAlignment(Pos.CENTER_RIGHT);
                tf.setPrefWidth((sceneWidth - 40)*0.21);
                tmpHbox.getChildren().addAll(lab, tf);
            }

            child.add(tmpHbox);
        }

        return resVbox;
    }

    public HBox getButtons(){
        HBox btnContainer = new HBox();
        btnContainer.setMaxWidth(sceneWidth - 20);
        btnContainer.setSpacing(5);
        btnContainer.setAlignment(Pos.CENTER);

        for(int i = 0; i < btnLabels.length; i++){
            Button btn = new Button(btnLabels[i]);
            btn.setPrefWidth((sceneWidth - 20)*0.22);
            btn.setStyle("-fx-background-color: #FFD499; -fx-border-color: #f0f0f0; -fx-border-width: 2px; -fx-border-radius: 3px;");
            btn = addAction(btn, i);
            btnContainer.getChildren().add(btn);
        }

        return btnContainer;
    }

    public Button addAction(Button btn, int idx){
        switch (idx){
            case 0: {
                btn.setOnAction(e -> {
                    double price;
                    int quantity;

                    try {
                        if(fields.get(2).getText().trim() != "" && fields.get(2).getText().trim().charAt(0) == '$'){
                            String pr = fields.get(2).getText().trim().substring(1);
                            price = Double.parseDouble(pr);
                        }else{
                            price = Double.parseDouble(fields.get(2).getText().trim());
                        }
                        fields.get(2).setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
                    } catch (NumberFormatException err) {
                        fields.get(2).setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                        return;
                    }

                    try {
                        quantity = Integer.parseInt(fields.get(3).getText().trim());
                        fields.get(3).setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
                    } catch (NumberFormatException err) {
                        fields.get(3).setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                        return;
                    }

                    String subTotal = Double.toString(truncate(truncate(price)*quantity));
                    fields.get(4).setText("$" + subTotal);

                });
                break;
            }
            case 1: {
                btn.setOnAction(e -> {
                    for(int i = 0; i < defaultValue.length; i++){
                        fields.get(i).setText(defaultValue[i]);
                    }
                });
                break;
            }
            case 2: {
                btn.setOnAction(e -> {
                    double tax, subTotal;
                    try {
                        String subt = fields.get(4).getText().trim().substring(1);
                        subTotal = Double.parseDouble(subt);
                        fields.get(4).setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
                    } catch (NumberFormatException err) {
                        fields.get(4).setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                        return;
                    }

                    tax = truncate(truncate(subTotal)*0.06);//niit uniin 6%-aar bodson
                    String salesTax = Double.toString(tax);
                    fields.get(5).setText("$" + salesTax);

                    double total = truncate(subTotal) + tax;
                    String totalDue = Double.toString(truncate(total));
                    fields.get(6).setText("$" + totalDue);
                });
                break;
            }
            case 3: {
                btn.setOnAction(e -> {
                    Platform.exit();
                });
                break;
            }
        }
        return btn;
    }

    public static double truncate(double input) {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        String formatResult = decimalFormat.format(input);
        return Double.parseDouble(formatResult);
    }

    public static void main(String[] args) {
        launch();
    }
}