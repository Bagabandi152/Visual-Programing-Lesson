module com.example.vpexam01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vpexam01 to javafx.fxml;
    exports com.example.vpexam01;
}