package com.example.vphw10;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * @author Littl
 * @project vphw10
 * @created 10/05/2022 - 8:02 PM
 */
public class ThreadsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRun;

    @FXML
    private Label lab1;

    @FXML
    private Label lab10;

    @FXML
    private Label lab11;

    @FXML
    private Label lab12;

    @FXML
    private Label lab13;

    @FXML
    private Label lab14;

    @FXML
    private Label lab15;

    @FXML
    private Label lab16;

    @FXML
    private Label lab17;

    @FXML
    private Label lab18;

    @FXML
    private Label lab19;

    @FXML
    private Label lab2;

    @FXML
    private Label lab20;

    @FXML
    private Label lab21;

    @FXML
    private Label lab3;

    @FXML
    private Label lab4;

    @FXML
    private Label lab5;

    @FXML
    private Label lab6;

    @FXML
    private Label lab7;

    @FXML
    private Label lab8;

    @FXML
    private Label lab9;

    @FXML
    private ProgressBar pb1;

    @FXML
    private ProgressBar pb10;

    @FXML
    private ProgressBar pb11;

    @FXML
    private ProgressBar pb12;

    @FXML
    private ProgressBar pb13;

    @FXML
    private ProgressBar pb14;

    @FXML
    private ProgressBar pb15;

    @FXML
    private ProgressBar pb16;

    @FXML
    private ProgressBar pb17;

    @FXML
    private ProgressBar pb18;

    @FXML
    private ProgressBar pb19;

    @FXML
    private ProgressBar pb2;

    @FXML
    private ProgressBar pb20;

    @FXML
    private ProgressBar pb21;

    @FXML
    private ProgressBar pb3;

    @FXML
    private ProgressBar pb4;

    @FXML
    private ProgressBar pb5;

    @FXML
    private ProgressBar pb6;

    @FXML
    private ProgressBar pb7;

    @FXML
    private ProgressBar pb8;

    @FXML
    private ProgressBar pb9;

//    private ObservableList<Service<ObservableList<Integer>>> services;

    private Service<ObservableList<Integer>> service1;

    @FXML
    void initialize() {
        assert btnRun != null : "fx:id=\"btnRun\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab1 != null : "fx:id=\"lab1\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab10 != null : "fx:id=\"lab10\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab11 != null : "fx:id=\"lab11\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab12 != null : "fx:id=\"lab12\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab13 != null : "fx:id=\"lab13\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab14 != null : "fx:id=\"lab14\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab15 != null : "fx:id=\"lab15\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab16 != null : "fx:id=\"lab16\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab17 != null : "fx:id=\"lab17\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab18 != null : "fx:id=\"lab18\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab19 != null : "fx:id=\"lab19\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab2 != null : "fx:id=\"lab2\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab20 != null : "fx:id=\"lab20\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab21 != null : "fx:id=\"lab21\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab3 != null : "fx:id=\"lab3\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab4 != null : "fx:id=\"lab4\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab5 != null : "fx:id=\"lab5\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab6 != null : "fx:id=\"lab6\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab7 != null : "fx:id=\"lab7\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab8 != null : "fx:id=\"lab8\" was not injected: check your FXML file 'threads.fxml'.";
        assert lab9 != null : "fx:id=\"lab9\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb1 != null : "fx:id=\"pb1\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb10 != null : "fx:id=\"pb10\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb11 != null : "fx:id=\"pb11\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb12 != null : "fx:id=\"pb12\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb13 != null : "fx:id=\"pb13\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb14 != null : "fx:id=\"pb14\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb15 != null : "fx:id=\"pb15\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb16 != null : "fx:id=\"pb16\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb17 != null : "fx:id=\"pb17\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb18 != null : "fx:id=\"pb18\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb19 != null : "fx:id=\"pb19\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb2 != null : "fx:id=\"pb2\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb20 != null : "fx:id=\"pb20\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb21 != null : "fx:id=\"pb21\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb3 != null : "fx:id=\"pb3\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb4 != null : "fx:id=\"pb4\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb5 != null : "fx:id=\"pb5\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb6 != null : "fx:id=\"pb6\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb7 != null : "fx:id=\"pb7\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb8 != null : "fx:id=\"pb8\" was not injected: check your FXML file 'threads.fxml'.";
        assert pb9 != null : "fx:id=\"pb9\" was not injected: check your FXML file 'threads.fxml'.";

//        services.forEach((service) -> {
//            service = createService();
//        });

        service1 = createService();
    }

    @FXML
    void toRun(ActionEvent event) {
        btnRun.setDisable(true);

        pb1.progressProperty().unbind();

        pb1.progressProperty().bind(service1.progressProperty());

//        lab1.setText(pb1.getProgress()*100 + "%");

        service1.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent t) {
                        btnRun.setDisable(false);
                        pb1.progressProperty().unbind();
                    }
                });

        service1.start();

    }


    Service<ObservableList<Integer>> createService() {
        return new Service <ObservableList < Integer >> () {
            @Override
            protected Task<ObservableList<Integer>> createTask () {
                return new Task<ObservableList<Integer>>() {
                    @Override
                    protected ObservableList<Integer> call() throws Exception {
                        Random random = new Random();
                        int max = 200;
                        int min = 10;
                        int citizens = random.nextInt(max - min) + min;
                        ObservableList<Integer> numberList = FXCollections.observableArrayList();
                        try {
                            for (int i = 1; i <= citizens; i++) {

                                if (isCancelled()) {
                                    break;
                                }

                                numberList.add(i);
                                this.updateProgress(i, citizens);
                                Thread.sleep(200);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return numberList;
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
}

