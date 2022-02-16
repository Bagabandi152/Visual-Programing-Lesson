module com.example.vplab02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vplab02 to javafx.fxml;
    exports com.example.vplab02;
}