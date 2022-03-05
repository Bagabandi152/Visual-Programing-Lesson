module com.example.stagedemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stagedemo to javafx.fxml;
    exports com.example.stagedemo;
}