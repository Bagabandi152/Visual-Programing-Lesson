package com.example.vplab12;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.List;
import java.util.Random;

public class DiceController {

    Random random = new Random();

    @FXML
    private ImageView diceImage;


    @FXML
    private Button btnCancel;

    @FXML
    private Button btnReset;

    @FXML
    private Button rollButton;

    @FXML
    private ProgressBar pbRolling;

    @FXML
    private ProgressIndicator piRolling;

//    private DiceService diceService;
    private Service<ObservableList<Image>> diceService;

    @FXML
    void onCancel(ActionEvent event) {
        rollButton.setDisable(false);
        btnCancel.setDisable(true);
//        diceService.cancel(true);
        pbRolling.progressProperty().unbind();
        piRolling.progressProperty().unbind();

        pbRolling.setProgress(0);
        piRolling.setProgress(0);
    }

    @FXML
    void onReset(ActionEvent event) {

    }

    @FXML
    void roll(ActionEvent event) {

        rollButton.setDisable(true);

        pbRolling.setProgress(0);
        piRolling.setProgress(0);
        btnCancel.setDisable(false);

        diceService = new Service<ObservableList<Image>>() {
            @Override
            protected Task<ObservableList<Image>> createTask() {
                Random random = new Random();
                ObservableList<Image> imgList = FXCollections.observableArrayList();
                try {
                    for (int i = 1; i <= 100; i++) {
                        File file = new File("src\\main\\resources\\com\\example\\vplab12\\Dice\\Dice" + (random.nextInt(6)+1)+".png");
                        diceImage.setImage(new Image(file.toURI().toString()));
                        imgList.add(new Image(file.toURI().toString()));
                        Thread.sleep(450);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return new Task<ObservableList<Image>>() {
                    @Override
                    protected ObservableList<Image> call() throws Exception {
                        for(int i = 1; i <= 100; i++) {
                            this.updateProgress(i, 100.0);
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return imgList;
                    }
                };
            }
        };

        pbRolling.progressProperty().unbind();

        pbRolling.progressProperty().bind(diceService.progressProperty());

        piRolling.progressProperty().unbind();

        piRolling.progressProperty().bind(diceService.progressProperty());

        diceService.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, //
                new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent t) {
                        rollButton.setDisable(false);
                    }
                });

        Service<ObservableList<Image>> service = new DiceService();

        service.start();

//        Thread thread = new Thread(){
//            public void run(){
//                System.out.println("Thread Running");
//                try {
//                    for (int i = 1; i <= 100; i++) {
//                        File file = new File("src\\main\\resources\\com\\example\\vplab12\\Dice\\Dice" + (random.nextInt(6)+1)+".png");
//                        diceImage.setImage(new Image(file.toURI().toString()));
//                        pbRolling.setProgress(i/100.0);
//                        piRolling.setProgress(i/100.0);
//                        Thread.sleep(450);
//                    }
//                    rollButton.setDisable(false);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        thread.start();
    }
}
