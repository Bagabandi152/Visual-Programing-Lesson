package com.example.vphw10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.image.Image;

import java.io.File;
import java.util.Random;

/**
 * @author Littl
 * @project vphw10
 * @created 10/05/2022 - 8:50 PM
 */
public class ThreadService extends Service<ObservableList<Integer>> {
    @Override
    protected Task<ObservableList<Integer>> createTask() {
        return new Task<ObservableList<Integer>>() {
            @Override
            protected ObservableList<Integer> call() throws Exception {
                Random random = new Random();
                int max = 50000;
                int min = 30000;
                int citizens = 100;// random.nextInt(max - min) + min;
                ObservableList<Integer> numberList = FXCollections.observableArrayList();
                try {
                    for (int i = 1; i <= citizens; i++) {

                        if(isCancelled()){
                            break;
                        }

                        numberList.add(i);
                        this.updateProgress(i, citizens);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return numberList;
            }

            @Override protected void succeeded() {
                super.succeeded();
                updateMessage("Done!");
            }

            @Override protected void cancelled() {
                super.cancelled();
                updateMessage("Cancelled!");
            }

            @Override protected void failed() {
                super.failed();
                updateMessage("Failed!");
            }
        };
    }
}
