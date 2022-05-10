module com.example.vphw10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vphw10 to javafx.fxml;
    exports com.example.vphw10;
}