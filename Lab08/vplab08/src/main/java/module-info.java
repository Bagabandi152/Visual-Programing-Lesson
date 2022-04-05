module com.example.vplab08 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jaxb.api;


    opens com.example.vplab08 to javafx.fxml;
    exports com.example.vplab08;
}