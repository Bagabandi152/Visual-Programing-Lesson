package com.example.vphw08withdb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.vphw08withdb.Model.PartDescription;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;

public class MainController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnNewAutoPart;

    @FXML
    private Button btnNewCustomerOrder;

    @FXML
    private Button btnOpen;

    @FXML
    private Button btnSave;

    @FXML
    private TableColumn<PartDescription, String> colPartName;

    @FXML
    private TableColumn<PartDescription, String> colPartNameSelected;

    @FXML
    private TableColumn<PartDescription, Integer> colPartNumber;

    @FXML
    private TableColumn<PartDescription, Integer> colPartNumberSelected;

    @FXML
    private TableColumn<PartDescription, Double> colQuantitySelected;

    @FXML
    private TableColumn<PartDescription, Double> colSubTotalSelected;

    @FXML
    private TableColumn<PartDescription, Integer> colUnitPrice;

    @FXML
    private TableColumn<PartDescription, Double> colUnitPriceSelected;

    @FXML
    private TreeView<PartDescription> tvwAutoParts;

    @FXML
    private TextField txtOpen;

    @FXML
    private TextField txtOrderTotal;

    @FXML
    private TextField txtPartName;

    @FXML
    private TextField txtPartNumber;

    @FXML
    private TextField txtPartsTotal;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtSave;

    @FXML
    private TextField txtSubTotal;

    @FXML
    private TextField txtTaxAmount;

    @FXML
    private TextField txtTaxRate;

    @FXML
    void initialize() {
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert btnNewAutoPart != null : "fx:id=\"btnNewAutoPart\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert btnNewCustomerOrder != null : "fx:id=\"btnNewCustomerOrder\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert btnOpen != null : "fx:id=\"btnOpen\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert colPartName != null : "fx:id=\"colPartName\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert colPartNameSelected != null : "fx:id=\"colPartNameSelected\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert colPartNumber != null : "fx:id=\"colPartNumber\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert colPartNumberSelected != null : "fx:id=\"colPartNumberSelected\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert colQuantitySelected != null : "fx:id=\"colQuantitySelected\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert colSubTotalSelected != null : "fx:id=\"colSubTotalSelected\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert colUnitPrice != null : "fx:id=\"colUnitPrice\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert colUnitPriceSelected != null : "fx:id=\"colUnitPriceSelected\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert tvwAutoParts != null : "fx:id=\"tvwAutoParts\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert txtOpen != null : "fx:id=\"txtOpen\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert txtOrderTotal != null : "fx:id=\"txtOrderTotal\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert txtPartName != null : "fx:id=\"txtPartName\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert txtPartNumber != null : "fx:id=\"txtPartNumber\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert txtPartsTotal != null : "fx:id=\"txtPartsTotal\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert txtQuantity != null : "fx:id=\"txtQuantity\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert txtSave != null : "fx:id=\"txtSave\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert txtSubTotal != null : "fx:id=\"txtSubTotal\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert txtTaxAmount != null : "fx:id=\"txtTaxAmount\" was not injected: check your FXML file 'main-pv.fxml'.";
        assert txtTaxRate != null : "fx:id=\"txtTaxRate\" was not injected: check your FXML file 'main-pv.fxml'.";
    }

    @FXML
    void addOrSelect(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void newAutoPart(ActionEvent event) throws IOException {
        new PartEditorStage();
    }

    @FXML
    void newCustomerOrder(ActionEvent event) {

    }

    @FXML
    void open(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {

    }

}
