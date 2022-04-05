package com.example.vphw04;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HelloController {

    @FXML
    private Button btnClose;

    @FXML
    private DatePicker dtpLoanEndDate;

    @FXML
    private DatePicker dtpStartDate;

    @FXML
    private TextField txtFutureValue;

    @FXML
    private TextField txtInterestEarned;

    @FXML
    private TextField txtInterestRate;

    @FXML
    private TextField txtPeriods;

    @FXML
    private TextField txtPrincipal;

    @FXML
    void initialize() {
        txtPrincipal.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
                calculate();
            }
        });
        txtInterestRate.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
                calculate();
            }
        });
        txtPeriods.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
                calculate();
            }
        });

        dtpStartDate.setValue(LocalDate.now());
        dtpLoanEndDate.setValue(LocalDate.now());

        dtpStartDate.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                calculate();
            }
        });

        dtpLoanEndDate.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                calculate();
            }
        });
    }

    void calculate(){
        double dPrincipal = 0.00D, dInterestRate = 0.00D;
        double periodsValue = 0;
        Date startDate, endDate;

        //Get the value of principal
        try {
            dPrincipal = Double.parseDouble(txtPrincipal.getText().trim());
            txtPrincipal.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
        } catch (NumberFormatException err) {
            txtPrincipal.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
            return;
        }

        // Get the interest rate
        try {
            dInterestRate = Double.parseDouble(txtInterestRate.getText().trim()) / 100;
            txtInterestRate.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
        } catch (NumberFormatException err) {
            txtInterestRate.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
            return;
        }

        DoubleProperty principal = new SimpleDoubleProperty(dPrincipal);
        DoubleProperty interestRate = new SimpleDoubleProperty(dInterestRate);

        // Get the start and end dates
        LocalDate localDateStart = dtpStartDate.getValue();
        Instant instantStart = Instant.from(localDateStart.atStartOfDay(ZoneId.systemDefault()));
        startDate = Date.from(instantStart);

        LocalDate localDateEnd = dtpLoanEndDate.getValue();
        Instant instantEnd = Instant.from(localDateEnd.atStartOfDay(ZoneId.systemDefault()));
        endDate = Date.from(instantEnd);

        // Make sure the end date doesn't occur before the start date
        if (startDate.after(endDate)){
            dtpLoanEndDate.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
            dtpLoanEndDate.setValue(dtpStartDate.getValue());
            return;
        }else{
            dtpLoanEndDate.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
        }

        // Get the difference in days
        // will be the periods
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if(days == 0) days = 1;
        txtPeriods.setText(Long.toString(days));

        // Because we will allow the user to directly specify
        // the number of days, let's get the period from its text box
        try {
            periodsValue = Double.parseDouble(txtPeriods.getText().trim());
            txtPeriods.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
        } catch (NumberFormatException err) {
            txtPeriods.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
            return;
        }

        DoubleProperty pVal = new SimpleDoubleProperty(periodsValue);

        // The actual period is gotten as follows
        DoubleProperty dp = new SimpleDoubleProperty();
        dp.bind(pVal.divide(365));

        // Now we can perform the calculations
        DoubleProperty ie = new SimpleDoubleProperty();
        ie.bind(principal.multiply(interestRate.multiply(dp)));

        DoubleProperty df = new SimpleDoubleProperty();
        df.bind(principal.add(ie));

        // Display the values
        txtInterestEarned.setText("$" + truncate(ie.getValue()));
        txtFutureValue.setText("$" + truncate(df.getValue()));
    }

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

    public static String truncate(double input) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String formatResult = decimalFormat.format(input);
        return formatResult.trim();
    }
}
