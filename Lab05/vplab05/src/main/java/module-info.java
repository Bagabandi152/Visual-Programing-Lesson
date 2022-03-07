module com.example.vplab05 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vplab05 to javafx.fxml;
    exports com.example.vplab05;
}