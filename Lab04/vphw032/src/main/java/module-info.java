module com.example.vphw032 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vphw032 to javafx.fxml;
    exports com.example.vphw032;
}