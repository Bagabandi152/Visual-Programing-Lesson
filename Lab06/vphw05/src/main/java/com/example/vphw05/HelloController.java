package com.example.vphw05;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.converter.FontConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HelloController {

    @FXML
    private Button btnOk;

    @FXML
    private ComboBox<String> chooseColor;

    @FXML
    private Rectangle colorIdent;

    @FXML
    private ListView<String> lvFont;

    @FXML
    private ListView<Integer> lvSize;

    @FXML
    private ListView<String> lvStyle;

    @FXML
    private TextField tfFont;

    @FXML
    private TextField tfSize;

    @FXML
    private TextField tfStyle;

    @FXML
    private CheckBox underline;

    @FXML
    private Label sampleTxt;

    ObservableList<String> fonts = FXCollections.observableArrayList(Font.getFamilies());
    ObservableList<String> styles = FXCollections.observableArrayList("Regular", "Italic", "Bold", "Bold Italic");
    ObservableList<Integer> sizes = FXCollections.observableArrayList(8, 10, 12, 14, 18, 24, 36);
    ObservableList<String> colors = FXCollections.observableArrayList("Black", "Green", "Blue", "Yellow", "Magenta", "Cyan", "White", "Gray", "Light Gray", "Dark Gray", "Pink", "Orange");
    ObservableList<Color> colorList = FXCollections.observableArrayList(Color.BLACK, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.WHITE, Color.GRAY, Color.LIGHTGRAY, Color.DARKGRAY, Color.PINK, Color.ORANGE);

    @FXML
    void initialize(){
        lvFont.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        lvFont.getItems().addAll(fonts);
        lvFont.getSelectionModel().select(0);
        tfFont.setText(fonts.get(0));
        lvFont.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                tfFont.setText(t1);
            }
        });

        lvStyle.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        lvStyle.getItems().addAll(styles);
        lvStyle.getSelectionModel().select(0);
        tfStyle.setText(styles.get(0));
        lvStyle.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                tfStyle.setText(t1);
                toChange();
            }
        });

        lvSize.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        lvSize.getItems().addAll(sizes);
        lvSize.getSelectionModel().select(2);
        tfSize.setText(sizes.get(2).toString());
        lvSize.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer s, Integer t1) {
                tfSize.setText(t1.toString());
            }
        });

        chooseColor.getItems().addAll(colors);
        chooseColor.getSelectionModel().select(0);
        colorIdent.setFill(Color.BLACK);
        chooseColor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                IntegerProperty idx = new SimpleIntegerProperty(colors.indexOf(t1));
                colorIdent.setFill(colorList.get(idx.getValue()));
            }
        });


        tfFont.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                toChange();
            }
        });

        tfStyle.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                toChange();
            }
        });

        tfSize.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                toChange();
            }
        });

        underline.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                toChange();
            }
        });
    }

    void toChange() {

        BooleanProperty underLine = new SimpleBooleanProperty(underline.isSelected());
        sampleTxt.setUnderline(underLine.getValue());
        sampleTxt.setTextFill(colorIdent.getFill());

        StringProperty fontName = new SimpleStringProperty(tfFont.getText());
        StringProperty fontSize = new SimpleStringProperty(tfSize.getText());

        Font ft = new Font(fontName.getValue(), Double.parseDouble(fontSize.getValue()));
        StringProperty fontStyle = new SimpleStringProperty(tfStyle.getText());

        if(fontStyle.getValue().toUpperCase().equals("REGULAR")){
            sampleTxt.setStyle("-fx-font-weight: normal;");
        }

        if(fontStyle.getValue().toUpperCase().equals("ITALIC")){
            sampleTxt.setStyle("-fx-font-style: italic;");
        }

        if(fontStyle.getValue().toUpperCase().equals("BOLD")){
            sampleTxt.setStyle("-fx-font-weight: bold;");
        }

        if(fontStyle.getValue().toUpperCase().equals("BOLD ITALIC")){
            sampleTxt.setStyle("-fx-font-weight: bold;");
            sampleTxt.setStyle("-fx-font-style: italic;");
        }

        sampleTxt.setFont(ft);
    }

    @FXML
    void close(ActionEvent event){
        Platform.exit();
    }

}
