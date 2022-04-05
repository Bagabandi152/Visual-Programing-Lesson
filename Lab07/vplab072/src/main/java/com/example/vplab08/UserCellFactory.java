package com.example.vplab08;

import com.example.vplab08.Model.User;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UserCellFactory implements Callback<ListView<User>, ListCell<User>> {
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
}
