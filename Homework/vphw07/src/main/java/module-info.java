module com.example.vphw07 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vphw07 to javafx.fxml;
    exports com.example.vphw07;
}