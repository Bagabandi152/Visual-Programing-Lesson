package com.example.vphw08withdb;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MakeEditorController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOK;

    @FXML
    private TextField txtMake;

    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'make-editor-pv.fxml'.";
        assert btnOK != null : "fx:id=\"btnOK\" was not injected: check your FXML file 'make-editor-pv.fxml'.";
        assert txtMake != null : "fx:id=\"txtMake\" was not injected: check your FXML file 'make-editor-pv.fxml'.";

    }

    @FXML
    void addMake(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
