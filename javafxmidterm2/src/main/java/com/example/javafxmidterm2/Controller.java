package com.example.javafxmidterm2;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static int N = 100;

    private List<Integer> area1;
    private List<Integer> area2;
    private List<Integer> area3;
    private List<Integer> area4;

    private ArrayList<Service<Void>> services = new ArrayList<>();

    private List<Label> lblListProcess;
    private List<ProgressBar> pbListProcess;

    private static int cnt = 0;

    @FXML
    private ProgressBar combine1ProcessPb;

    @FXML
    private Label combine1ProcessPc;

    @FXML
    private ProgressBar combine2ProcessPb;

    @FXML
    private Label combine2ProcessPc;

    @FXML
    private ProgressBar combine3ProcessPb;

    @FXML
    private Label combine3ProcessPc;

    @FXML
    private ProgressBar combine4ProcessPb;

    @FXML
    private Label combine4ProcessPc;


    @FXML
    private ProgressBar allCombinePb;

    @FXML
    private Label allCombinePc;

    @FXML
    private Label combine1Cnt;

    @FXML
    private Label combine2Cnt;

    @FXML
    private Label combine3Cnt;

    @FXML
    private Label combine4Cnt;

    @FXML
    private Label mostHarvestCnt;

    @FXML
    private Label mostHarvestCombine;


    @FXML
    private Label allCombineCnt;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        area1 = new ArrayList<>();
        area2 = new ArrayList<>();
        area3 = new ArrayList<>();
        area4 = new ArrayList<>();

        pbListProcess = new ArrayList<>(List.of(combine1ProcessPb, combine2ProcessPb, combine3ProcessPb, combine4ProcessPb));
        lblListProcess = new ArrayList<>(List.of(combine1ProcessPc, combine2ProcessPc, combine3ProcessPc, combine4ProcessPc));

        List<Integer> allSum1 = new ArrayList<>();
        List<Integer> allSum2 = new ArrayList<>();
        List<Integer> allSum3 = new ArrayList<>();
        List<Integer> allSum4 = new ArrayList<>();

        int ind = 0,
                sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(ind%4 ==  0){
                    int rand = generateRandomNumber(1, 5);
                    area1.add(rand);
                    sum1 += rand;
                    allSum1.add(sum1);
                }else if(ind%4 == 1){
                    int rand = generateRandomNumber(1, 5);
                    area2.add(rand);
                    sum2 += rand;
                    allSum2.add(sum2);
                }else if(ind%4 == 2){
                    int rand = generateRandomNumber(1, 5);
                    area3.add(rand);
                    sum3 += rand;
                    allSum3.add(sum3);
                }else{
                    int rand = generateRandomNumber(1, 5);
                    area4.add(rand);
                    sum4 += rand;
                    allSum4.add(sum4);
                }
                ind++;
            }
        }

        services.add(new ThreadService(sum1));
        services.add(new ThreadService(sum2));
        services.add(new ThreadService(sum3));
        services.add(new ThreadService(sum4));

        System.out.println("sum1: " + sum1 + " sum2: " + sum2  + " sum3: " + sum3 + " sum4: " + sum4);

        for(int i = 0; i < services.size(); i++){
            ProgressBar pb = pbListProcess.get(i);
            Label lab = lblListProcess.get(i);
            Service<Void> service = services.get(i);

            pb.progressProperty().unbind();

            pb.progressProperty().bind(service.progressProperty());

            final int idx = i;
            final int finalSum1 = sum1, finalSum2 = sum2, finalSum3 = sum3, finalSum4 = sum4;
            pb.progressProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    lab.setText(Integer.toString((int)Math.ceil((t1.doubleValue()) * 100)));
                    if(idx == 0){
                        combine1Cnt.setText(Integer.toString(allSum1.get((int)Math.ceil((t1.doubleValue()) * finalSum1))));
                    }else if(idx == 1){
                        combine1Cnt.setText(Integer.toString(allSum2.get((int)Math.ceil((t1.doubleValue()) * finalSum2))));
                    }else if(idx == 2){
                        combine1Cnt.setText(Integer.toString(allSum3.get((int)Math.ceil((t1.doubleValue()) * finalSum3))));
                    }else{
                        combine1Cnt.setText(Integer.toString(allSum4.get((int)Math.ceil((t1.doubleValue()) * finalSum4))));
                    }
                }
            });

            service.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                    new EventHandler<WorkerStateEvent>() {
                        @Override
                        public void handle(WorkerStateEvent t) {
                            cnt++;
                        }
                    });

            service.start();
        }

//        Service<Void> service = new ThreadService(cnt, null);
//
//        allCombinePb.progressProperty().unbind();
//
//        allCombinePb.progressProperty().bind(service.progressProperty());
//
//        allCombinePb.progressProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//                allCombinePc.setText(Integer.toString((int)Math.ceil((t1.doubleValue()) * 100)));
//            }
//        });
//
//        service.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent t) {
//                //...
//            }
//        });
//
//        service.start();

        int mx = 0;
        if (sum1 > sum2) {
            if (sum1 > sum3) {
                if (sum1 > sum4) {
                    mx = sum1;
                }
                else {
                    mx = sum4;
                }
            }
        } else if (sum2 > sum3) {
            if (sum2 > sum4) {
                mx = sum2;
            }
            else {
                mx = sum4;
            }
        }
        else if (sum3 > sum4) {
            mx = sum3;
        }
        else {
            mx = sum4;
        }
        
        mostHarvestCnt.setText(Integer.toString(mx));
        if(mx == sum1){
            mostHarvestCombine.setText("Combine 1:");
        }else if(mx == sum2){
            mostHarvestCombine.setText("Combine 2:");
        }else if(mx == sum3){
            mostHarvestCombine.setText("Combine 3:");
        }else{
            mostHarvestCombine.setText("Combine 4:");
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

