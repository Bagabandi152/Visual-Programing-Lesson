package com.example.vplab08;

import com.example.vplab08.Model.Order;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    public TableView<Order> exampleTable;
    public TableColumn<Order, Integer> orderIdColumn;
    public TableColumn<Order, String> stateColumn;
    public TableColumn<Order, String> cityColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        stateColumn.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "New York", "New York")); //8,323,340
        orders.add(new Order(2, "Colorado", "Denver"));
        orders.add(new Order(3, "Missouri", "Kansas City"));
        orders.add(new Order(4, "Nebraska", "Custer"));
        orders.add(new Order(5, "Iowa", "Black Hawk"));
        orders.add(new Order(6, "Nevada", "Las Vegas"));
        orders.add(new Order(7, "California", "San Diego")); //1.54m
        orders.add(new Order(8, "Illinois", "Chicago")); //2.2m
        orders.add(new Order(9, "Massachusetts", "Boston")); //4.3m
        orders.add(new Order(10, "Vermont", "Montpellier"));
        orders.add(new Order(11, "Revelstoke", "Alberta"));
        orders.add(new Order(12, "Winnipeg", "Manitoba"));
        orders.add(new Order(13, "Terrace", "British Colombia"));

        ObservableList<Order> ol = FXCollections.observableArrayList(orders);
        exampleTable.setItems(ol);

        PseudoClass higlighted = PseudoClass.getPseudoClass("highlighted");
        exampleTable.setRowFactory(tableView -> {
            TableRow<Order> row = new TableRow<>();
            row.itemProperty().addListener((obs, oldOrder, newOrder) ->
                    row.pseudoClassStateChanged(higlighted,
                            newOrder.getCity().equals("New York") ||
                                    newOrder.getCity().equals("Boston")));
            return row;
        });
    }

    @FXML
    private void handleExitButtonClicked(ActionEvent event) {
        Platform.exit();
        event.consume();
    }
}