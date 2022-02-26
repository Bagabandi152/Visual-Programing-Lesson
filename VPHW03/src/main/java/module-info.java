module com.example.vphw03 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vphw03 to javafx.fxml;
    exports com.example.vphw03;
}