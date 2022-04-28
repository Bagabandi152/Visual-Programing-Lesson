package com.example.vphw08withdb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PartEditorController {

    @FXML
    private Button btnClose;

    @FXML
    private Button btnModels;

    @FXML
    private Button btnNewCategory;

    @FXML
    private Button btnNewMake;

    @FXML
    private Button btnSubmit;

    @FXML
    private ComboBox<String> cbxCategories;

    @FXML
    private ComboBox<String> cbxMakes;

    @FXML
    private ComboBox<String> cbxModels;

    @FXML
    private TextField txtItemNumber;

    @FXML
    private TextField txtPartName;

    @FXML
    private TextField txtPartNumber;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void initialize() {
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert btnModels != null : "fx:id=\"btnModels\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert btnNewCategory != null : "fx:id=\"btnNewCategory\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert btnNewMake != null : "fx:id=\"btnNewMake\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert btnSubmit != null : "fx:id=\"btnSubmit\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert cbxCategories != null : "fx:id=\"cbxCategories\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert cbxMakes != null : "fx:id=\"cbxMakes\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert cbxModels != null : "fx:id=\"cbxModels\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert txtItemNumber != null : "fx:id=\"txtItemNumber\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert txtPartName != null : "fx:id=\"txtPartName\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert txtPartNumber != null : "fx:id=\"txtPartNumber\" was not injected: check your FXML file 'part-editor-pv.fxml'.";
        assert txtUnitPrice != null : "fx:id=\"txtUnitPrice\" was not injected: check your FXML file 'part-editor-pv.fxml'.";

    }

    @FXML
    void close(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void newCategory(ActionEvent event) throws IOException {
        new ItemCategoryStage();
    }

    @FXML
    void newMake(ActionEvent event) throws IOException {
        new MakeEditorStage();
    }

    @FXML
    void newModel(ActionEvent event) throws IOException {
        new ModelEditorStage();
    }

    @FXML
    void submit(ActionEvent event) {

    }

}
