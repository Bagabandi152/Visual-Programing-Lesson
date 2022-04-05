module com.example.vphw06 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vphw06 to javafx.fxml;
    exports com.example.vphw06;
}