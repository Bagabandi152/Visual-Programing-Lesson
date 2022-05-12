package com.example.vphw10;

import java.net.URL;
import java.util.*;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private Label lab22;

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
    private ProgressBar pb22;

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

    private ArrayList<Service<Void>> services = new ArrayList<>();

    private Service<ObservableList<Integer>> service1;

    private ArrayList<ProgressBar> progressBars = new ArrayList<>();

    private ArrayList<Label> labels = new ArrayList<>();

    @FXML
    void initialize() {
        progressBars.addAll(Arrays.asList(pb1, pb2, pb3, pb4, pb5, pb6, pb7, pb8, pb9, pb10, pb11, pb12, pb13,
                pb14, pb15, pb16, pb17, pb18, pb19, pb20, pb21, pb22));

        labels.addAll(Arrays.asList(lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12,
                lab13, lab14, lab15, lab16, lab17, lab18, lab19, lab20, lab21, lab22));

        for(int i = 0;  i < 22; i++){
            Random random = new Random();
            int max = 50000;
            int min = 40000;
            int citizens = random.nextInt(max - min) + min;
            services.add(new ThreadService(citizens));
        }

    }

    @FXML
    void toRun(ActionEvent event) {
        btnRun.setDisable(true);

        for(int i = 0; i < services.size(); i++){
            ProgressBar pb = progressBars.get(i);
            Label lab = labels.get(i);
            Service<Void> service = services.get(i);

            pb.progressProperty().unbind();

            pb.progressProperty().bind(service.progressProperty());

            pb.progressProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    lab.setText((int)Math.ceil((t1.doubleValue()) * 100) + "%");
                }
            });

            final int idx = i;
            service.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
                    new EventHandler<WorkerStateEvent>() {
                        @Override
                        public void handle(WorkerStateEvent t) {
                            if (services.size() == idx + 1 ) btnRun.setDisable(false);
                        }
                    });

            service.start();
        }

    }
}

