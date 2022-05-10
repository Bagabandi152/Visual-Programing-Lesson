package com.example.vplab12;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.image.Image;

import java.io.File;
import java.util.Random;

public class DiceService extends Service<ObservableList<Image>> {
    @Override
    protected Task<ObservableList<Image>> createTask() {
        return new Task<ObservableList<Image>>() {
            @Override
            protected ObservableList<Image> call() throws Exception {
                Random random = new Random();
                ObservableList<Image> imgList = FXCollections.observableArrayList();
                try {
                    for (int i = 1; i <= 100; i++) {

                        if(isCancelled()){
                            break;
                        }

                        File file = new File("src\\main\\resources\\com\\example\\vplab12\\Dice\\Dice" + (random.nextInt(6)+1)+".png");
                        imgList.add(new Image(file.toURI().toString()));
                        this.updateProgress(i, 100.0);
                        Thread.sleep(450);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return imgList;
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
