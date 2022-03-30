package com.example.vphw06;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CustomerController {

    @FXML
    private Button btnClose;

    @FXML
    private Button btnNewCustomer;

    @FXML
    public TableView<String> tvwCustomers;


    @FXML
    void addCustomer(ActionEvent event) throws Exception {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setTitle("Customer Editor");
        stage.setWidth(3);
        stage.setHeight(277);

        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer-editor-view.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

}
