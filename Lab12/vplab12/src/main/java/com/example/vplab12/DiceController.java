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
import java.util.Random;

public class DiceController {

    @FXML
    private ImageView diceImage;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnRestart;

    @FXML
    private Button rollButton;

    @FXML
    private ProgressBar pbRolling;

    @FXML
    private ProgressIndicator piRolling;

    private Service<ObservableList<Image>> diceService;

    @FXML
    void onCancel(ActionEvent event) {
        rollButton.setDisable(false);
        btnCancel.setDisable(true);
        diceService.cancel();
    }

    @FXML
    void onReset(ActionEvent event) {
        diceService.reset();
        btnCancel.setDisable(true);
    }

    @FXML
    void onRestart(ActionEvent event) {
        pbRolling.setProgress(0);
        piRolling.setProgress(0);
        btnCancel.setDisable(false);
        btnReset.setDisable(false);

        diceService.restart();
    }

    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnRestart != null : "fx:id=\"btnRestart\" was not injected: check your FXML file 'sample.fxml'.";
        assert diceImage != null : "fx:id=\"diceImage\" was not injected: check your FXML file 'sample.fxml'.";
        assert pbRolling != null : "fx:id=\"pbRolling\" was not injected: check your FXML file 'sample.fxml'.";
        assert piRolling != null : "fx:id=\"piRolling\" was not injected: check your FXML file 'sample.fxml'.";
        assert rollButton != null : "fx:id=\"rollButton\" was not injected: check your FXML file 'sample.fxml'.";

        diceService = createService();

        btnRestart.setDisable(true);
        btnCancel.setDisable(true);
        btnReset.setDisable(true);
    }

    Service<ObservableList<Image>> createService(){
        return new Service<ObservableList<Image>>() {
            @Override
            protected Task<ObservableList<Image>> createTask () {
                return new Task<ObservableList<Image>>() {
                    @Override
                    protected ObservableList<Image> call() throws Exception {
                        Random random = new Random();
                        ObservableList<Image> imgList = FXCollections.observableArrayList();
                        try {
                            for (int i = 1; i <= 100; i++) {

                                if (isCancelled()) {
                                    break;
                                }

                                File file = new File("src\\main\\resources\\com\\example\\vplab12\\Dice\\Dice" + (random.nextInt(6) + 1) + ".png");
                                imgList.add(new Image(file.toURI().toString()));
                                diceImage.setImage(new Image(file.toURI().toString()));
                                this.updateProgress(i, 100.0);
                                Thread.sleep(350);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return imgList;
                    }

                    @Override
                    protected void succeeded() {
                        super.succeeded();
                        updateMessage("Done!");
                    }

                    @Override
                    protected void cancelled() {
                        super.cancelled();
                        updateMessage("Cancelled!");
                    }

                    @Override
                    protected void failed() {
                        super.failed();
                        updateMessage("Failed!");
                    }
                };
            }
        };
    }

    @FXML
    void roll(ActionEvent event) {

        rollButton.setDisable(true);

        pbRolling.setProgress(0);
        piRolling.setProgress(0);
        btnCancel.setDisable(false);
        btnReset.setDisable(false);

        pbRolling.progressProperty().unbind();

        pbRolling.progressProperty().bind(diceService.progressProperty());

        piRolling.progressProperty().unbind();

        piRolling.progressProperty().bind(diceService.progressProperty());

        diceService.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent t) {
                        btnRestart.setDisable(false);
                        btnReset.setDisable(true);
                    }
                });

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

        diceService.start();
    }
}
