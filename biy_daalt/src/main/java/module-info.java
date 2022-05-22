module com.biy_daalt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.biy_daalt to javafx.fxml;
    exports com.biy_daalt;
}