package com.example.vphw032;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private Button btnClose;

    @FXML
    private Button btnGenerate;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private TextField txtCurrentQtr1;

    @FXML
    private TextField txtCurrentQtr2;

    @FXML
    private TextField txtCurrentQtr3;

    @FXML
    private TextField txtCurrentQtr4;

    @FXML
    private TextField txtPreviousQtr1;

    @FXML
    private TextField txtPreviousQtr2;

    @FXML
    private TextField txtPreviousQtr3;

    @FXML
    private TextField txtPreviousQtr4;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void setBarChartColor(MouseEvent event) {
        //set first bar color
        for(Node n:barChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: #ff391f;");
        }

        //second bar color
        for(Node n:barChart.lookupAll(".default-color1.chart-bar")) {
            n.setStyle("-fx-bar-fill: #1e90ff;");
        }
    }

    @FXML
    void generate(ActionEvent event) {
        if(barChart.getData().isEmpty()){

            int[] curr = new int[4];
            int[] pre = new int[4];

            if(txtCurrentQtr1 == null || txtCurrentQtr2 == null || txtCurrentQtr3 == null || txtCurrentQtr4 == null){
                return;
            }

            if(txtPreviousQtr1 == null || txtPreviousQtr2 == null || txtPreviousQtr3 == null || txtPreviousQtr4 == null){
                return;
            }

            try {
                curr[0] = Integer.parseInt(txtCurrentQtr1.getText().trim());
                txtCurrentQtr1.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
            } catch (NumberFormatException err) {
                txtCurrentQtr1.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                return;
            }

            try {
                curr[1] = Integer.parseInt(txtCurrentQtr2.getText().trim());
                txtCurrentQtr2.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
            } catch (NumberFormatException err) {
                txtCurrentQtr2.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                return;
            }

            try {
                curr[2] = Integer.parseInt(txtCurrentQtr3.getText().trim());
                txtCurrentQtr3.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
            } catch (NumberFormatException err) {
                txtCurrentQtr3.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                return;
            }

            try {
                curr[3] = Integer.parseInt(txtCurrentQtr4.getText().trim());
                txtCurrentQtr4.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
            } catch (NumberFormatException err) {
                txtCurrentQtr4.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                return;
            }


            try {
                pre[0] = Integer.parseInt(txtPreviousQtr1.getText().trim());
                txtPreviousQtr1.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
            } catch (NumberFormatException err) {
                txtPreviousQtr1.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                return;
            }

            try {
                pre[1] = Integer.parseInt(txtPreviousQtr2.getText().trim());
                txtPreviousQtr2.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
            } catch (NumberFormatException err) {
                txtPreviousQtr2.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                return;
            }

            try {
                pre[2] = Integer.parseInt(txtPreviousQtr3.getText().trim());
                txtPreviousQtr3.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
            } catch (NumberFormatException err) {
                txtPreviousQtr3.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                return;
            }

            try {
                pre[3] = Integer.parseInt(txtPreviousQtr4.getText().trim());
                txtPreviousQtr4.setStyle("-fx-border-color: #d3d3d3; -fx-border-radius: 3px;");
            } catch (NumberFormatException err) {
                txtPreviousQtr4.setStyle("-fx-border-color: #f00; -fx-border-radius: 3px;");
                return;
            }

            // Series 1 - Current Year's Sales
            XYChart.Series<String, Number> dataSeries1 = new XYChart.Series();
            dataSeries1.setName(null);

            for(int i = 0; i < curr.length; i++){
                dataSeries1.getData().add(new XYChart.Data(Integer.toString(i), curr[i]/100));
            }

            // Series 2 - Previous Year's Sales
            XYChart.Series<String, Number> dataSeries2 = new XYChart.Series();
            dataSeries2.setName(null);

            for(int i = 0; i < pre.length; i++){
                dataSeries2.getData().add(new XYChart.Data(Integer.toString(i), pre[i]/100));
            }

            //Hide series name
            x.setTickLabelsVisible(false);
            x.setTickMarkVisible(false);

            // Add Series to BarChart.
            barChart.getData().addAll(dataSeries1, dataSeries2);
        }
    }
}