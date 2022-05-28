module com.example.uliraldemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uliraldemo to javafx.fxml;
    exports com.example.uliraldemo;
}