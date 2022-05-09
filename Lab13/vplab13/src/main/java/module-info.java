module com.example.vplab13 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;


    opens com.example.vplab13 to javafx.fxml;
    exports com.example.vplab13;
}