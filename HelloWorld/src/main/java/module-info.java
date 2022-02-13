module com.sample.helloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sample.helloworld to javafx.fxml;
    exports com.sample.helloworld;
}