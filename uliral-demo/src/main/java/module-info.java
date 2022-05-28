module com.example.uliraldemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.sql.rowset;


    opens com.example.uliraldemo to javafx.fxml;
    exports com.example.uliraldemo;
    exports com.example.uliraldemo.model;
    opens com.example.uliraldemo.model to javafx.fxml;
}