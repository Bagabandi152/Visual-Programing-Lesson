package com.example.vphw031;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class HelloController {
    @FXML
    private Button calc_btn;

    @FXML
    private Button close_btn;

    @FXML
    private TextField marked_price;

    @FXML
    private TextField net_price;

    @FXML
    private TextField tax_mount;

    @FXML
    private TextField tax_rate;

    @FXML
    void calcTaxAndNet(ActionEvent event) {
        double markedPrice;
        try {
            markedPrice = Double.parseDouble(marked_price.getText().trim());
            marked_price.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
        } catch (NumberFormatException err) {
            marked_price.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
            return;
        }

        double taxRate;
        try {
            String str = tax_rate.getText().trim();
            if(str.charAt(str.length() - 1) == '%'){
                str = str.substring(0, str.length() - 1);
            }
            System.out.println("str: "  + str);
            taxRate = Double.parseDouble(str);
            tax_rate.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
        } catch (NumberFormatException err) {
            tax_rate.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
            return;
        }

        double taxAmount = markedPrice*(taxRate/100);
        tax_mount.setText("$" + truncate(taxAmount));

        double netPrice = markedPrice + taxAmount;
        net_price.setText("$" + truncate(netPrice));

    }

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

    public static String truncate(double input) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        String formatResult = decimalFormat.format(input);
        return formatResult;
    }
}
