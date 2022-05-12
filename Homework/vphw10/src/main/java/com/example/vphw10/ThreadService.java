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
public class ThreadService extends Service<Void> {

    private int citizens;

    ThreadService(int citizens){
        this.citizens = citizens;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    for (int i = 1; i <= citizens; i++) {

                        if(isCancelled()){
                            break;
                        }
                        this.updateProgress(i, citizens);
                        Thread.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
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
