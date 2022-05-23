package com.example.javafxmidterm2;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.List;

public class ThreadService extends Service<Void> {

    private int areaSize;

    ThreadService(int areaSize){
        this.areaSize = areaSize;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    for (int i = 1; i <= areaSize; i++) {

                        if(isCancelled()){
                            break;
                        }
                        this.updateProgress(i, areaSize);
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
