module com.example.vplab03 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vplab03 to javafx.fxml;
    exports com.example.vplab03;
}