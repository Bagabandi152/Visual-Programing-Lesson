module com.example.vphw05 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vphw05 to javafx.fxml;
    exports com.example.vphw05;
}