package com.example.vplab08;

import com.example.vplab08.Model.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ListView<User> users = new ListView<>(FXCollections.observableArrayList(
                new User("Bat1", "1", "src/main/resources/img/201"),
                new User("Bat2", "1", "src/main/resources/img/202"),
                new User("Bat3", "0", "src/main/resources/img/203"),
                new User("Bat4", "1", "src/main/resources/img/204"),
                new User("Bat5", "1", "src/main/resources/img/205"),
                new User("Bat6", "0", "src/main/resources/img/206"),
                new User("Bat7", "1", "src/main/resources/img/207")
        ));


        users.setCellFactory(new Callback<>() {
            @Override
            public ListCell<User> call(ListView<User> users) {
                return new ListCell<>(){
                    @Override
                    public void updateItem(User user, boolean empty) {
                        super.updateItem(user, empty);
                        if (empty || user == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            String act = null;
                            if(user.getStatus().equals("1")){
                                act = "active";
                            }else if(user.getStatus().equals("0")){
                                act = "inactive";
                            }

                            setText(user.getName() + ", " + act);
                            ImageView image = null;
                            try {
                                System.out.println("url: " + user.getImgURL());
                                image = new ImageView(new Image(new FileInputStream(user.getImgURL() + ".jpg")));
                                image.setFitWidth(120);
                                image.setFitHeight(120);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            setGraphic(image);
                        }
                    }
                };
            }
        });
        Scene scene = new Scene(users, 300, 500);

        stage.setScene(scene);
        stage.setTitle("ListView Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}