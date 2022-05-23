package com.example.javafxmidterm2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static int N = 1000;

    private List<Integer> area1;
    private List<Integer> area2;
    private List<Integer> area3;
    private List<Integer> area4;

    @FXML
    private ProgressBar combine1Pb1;

    @FXML
    private Label combine1Pc1;

    @FXML
    private ProgressBar combine2Pb1;

    @FXML
    private Label combine2Pc1;

    @FXML
    private ProgressBar combine3Pb1;

    @FXML
    private Label combine3Pc1;

    @FXML
    private ProgressBar combine4Pb1;

    @FXML
    private Label combine4Pc1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        area1 = new ArrayList<>();
        area2 = new ArrayList<>();
        area3 = new ArrayList<>();
        area4 = new ArrayList<>();

        int ind = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(ind%4 ==  0){
                    area1.add(generateRandomNumber(1, 5));
                }else if(ind%4 == 1){
                    area2.add(generateRandomNumber(1, 5));
                }else if(ind%4 == 2){
                    area3.add(generateRandomNumber(1, 5));
                }else{
                    area4.add(generateRandomNumber(1, 5));
                }
            }
        }
    }

    public int generateRandomNumber(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public int getUnitNumber(int potatoRipening){
        switch (potatoRipening){
            case 1: return 5;
            case 2: return 4;
            case 3: return 3;
            case 4: return 2;
            default: return 1;
        }
    }
}

