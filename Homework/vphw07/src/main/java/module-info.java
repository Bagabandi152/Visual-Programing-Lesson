module com.example.vphw07 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.vphw07 to javafx.fxml;
    opens com.example.vphw07.Model to javafx.fxml;

    exports com.example.vphw07;
    exports com.example.vphw07.Model;
}