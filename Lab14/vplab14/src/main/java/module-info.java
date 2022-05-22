module com.example.vplab13 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires java.desktop;


    opens com.example.vplab14 to javafx.fxml;
    exports com.example.vplab14;
}