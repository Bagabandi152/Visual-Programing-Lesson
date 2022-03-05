module com.example.vphw031 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vphw031 to javafx.fxml;
    exports com.example.vphw031;
}