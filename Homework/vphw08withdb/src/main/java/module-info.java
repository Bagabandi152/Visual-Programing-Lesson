module com.example.vphw08withdb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vphw08withdb to javafx.fxml;
    exports com.example.vphw08withdb;
}