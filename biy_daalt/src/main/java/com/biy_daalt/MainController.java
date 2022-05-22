package com.biy_daalt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    List<ImageView> ivList;
    List<Image> imgList;

    @FXML
    private ImageView img1x1;

    @FXML
    private ImageView img1x2;

    @FXML
    private ImageView img1x3;

    @FXML
    private ImageView img1x4;

    @FXML
    private ImageView img2x1;

    @FXML
    private ImageView img2x2;

    @FXML
    private ImageView img2x3;

    @FXML
    private ImageView img2x4;

    @FXML
    private ImageView img3x1;

    @FXML
    private ImageView img3x2;

    @FXML
    private ImageView img3x3;

    @FXML
    private ImageView img3x4;

    @FXML
    private ImageView img4x1;

    @FXML
    private ImageView img4x2;

    @FXML
    private ImageView img4x3;

    @FXML
    private ImageView img4x4;

    @FXML
    private ImageView natural_img;

    @FXML
    private GridPane puzzle;

    @FXML
    private Label puzzleStatusLbl;

    @FXML
    private Button shuffleBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /**
         * Оргиналь зургийг natural_img imageView - д байрлуулна.
         */
        Image org_img = null;
        try {
            org_img = new Image(new FileInputStream("/images/natural_img.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        natural_img.setImage(org_img);

        /**
         * Бусад puzzle - ийн imageView - үүдийг жагсаалтад хийж авна.
         */

        ivList = new ArrayList<>(List.of(img1x1, img1x2, img1x3, img1x4, img2x1, img2x2, img2x3, img2x4, img3x1, img3x2, img3x3, img3x4, img4x1, img4x2, img4x3, img4x4));

        /**
         * puzzle - д байрлуулах зургуудыг resource - оос уншиж авна.
         */

        imgList = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            try {
                Image image = new Image(new FileInputStream("/image/" + i + ".jpg"));
                imgList.add(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void shuffle(ActionEvent event) {

    }
}
