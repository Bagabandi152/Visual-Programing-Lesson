module com.example.vplab12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vplab12 to javafx.fxml;
    exports com.example.vplab12;
}