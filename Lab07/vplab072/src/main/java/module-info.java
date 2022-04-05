module com.example.vplab08 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vplab08 to javafx.fxml;
    exports com.example.vplab08;
}