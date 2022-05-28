package com.example.uliraldemo;

import com.example.uliraldemo.dao.EmployeeDao;
import com.example.uliraldemo.model.Employee;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainApp extends Application {

    private Stage primaryStage;

    private final ObservableList<Employee> employees = FXCollections.observableArrayList();
    private final ObservableList<String> departments = FXCollections.observableArrayList();
    private final ObservableList<String> positions = FXCollections.observableArrayList();


    public MainApp(){
        try {
            getEmployees().addAll(EmployeeDao.getEmployeesFromDb());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<String> getPositions() {
        return positions;
    }

    public ObservableList<String> getDepartments() {
        return departments;
    }

    public ObservableList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initRootLayout();
    }


    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("sample.fxml"));
            BorderPane rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setMain(this);

            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
