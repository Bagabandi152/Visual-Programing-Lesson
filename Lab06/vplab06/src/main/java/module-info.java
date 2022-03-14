module com.example.vplab06 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vplab06 to javafx.fxml;
    exports com.example.vplab06;
}