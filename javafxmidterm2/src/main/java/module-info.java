module com.example.javafxmidterm2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxmidterm2 to javafx.fxml;
    exports com.example.javafxmidterm2;
}