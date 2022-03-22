module com.example.vplab07 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vplab07 to javafx.fxml;
    exports com.example.vplab07;
}