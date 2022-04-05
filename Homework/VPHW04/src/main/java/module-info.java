module com.example.vphw04 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vphw04 to javafx.fxml;
    exports com.example.vphw04;
}