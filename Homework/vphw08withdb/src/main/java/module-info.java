module com.example.vphw08withdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.vphw08withdb to javafx.fxml;
    exports com.example.vphw08withdb;
    exports  com.example.vphw08withdb.Model;
    exports com.example.vphw08withdb.DBHandler;
}