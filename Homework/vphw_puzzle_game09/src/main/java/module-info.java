module com.example.vphw_puzzle_game09 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    opens com.example.vphw_puzzle_game09 to javafx.fxml;
    exports com.example.vphw_puzzle_game09;
}