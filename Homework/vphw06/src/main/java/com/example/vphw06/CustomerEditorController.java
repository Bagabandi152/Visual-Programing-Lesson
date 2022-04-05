package com.example.vphw06;

import Model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerEditorController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOk;

    @FXML
    private TextField txtAccountNumber;

    @FXML
    private TextField txtEmergencyName;

    @FXML
    private TextField txtEmergencyPhone;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void close(ActionEvent event) throws Exception {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setTitle("Customers Records");
        stage.setWidth(550);
        stage.setHeight(300);
        Scene scene = stage.getScene();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customers-view.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        scene.setRoot(root);
    }

    @FXML
    void saveCustomer(ActionEvent event) {
        Customer newCustomer = new Customer(
                txtAccountNumber.toString(),
                txtFirstName.toString(),
                txtLastName.toString(),
                txtPhoneNumber.toString(),
                txtEmergencyName.toString(),
                txtEmergencyPhone.toString());
        CustomerController customerController = new CustomerController();
        customerController.tvwCustomers.getItems().add(newCustomer);
    }
}
