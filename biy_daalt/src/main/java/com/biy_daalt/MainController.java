package com.biy_daalt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static final int PUZZLE_SIZE = 4;

    private List<ImageView> ivList;
    private List<Image> imgList;

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

    Puzzle puzzleModel = new Puzzle(PUZZLE_SIZE);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        shuffleBtn.setText(null);
        shuffleBtn.setGraphic(new ImageView(new Image("file:src/main/resources/images/shuffle_arrows.png")));

        /**
         * Оргиналь зургийг natural_img imageView - д байрлуулна.
         */
        Image org_img = new Image("file:src/main/resources/images/natural_img.jpg");
        natural_img.setImage(org_img);

        /**
         * Бусад puzzle - ийн imageView - үүдийг жагсаалтад хийж авна.
         */
        ivList = new ArrayList<>(List.of(img1x1, img1x2, img1x3, img1x4, img2x1, img2x2, img2x3, img2x4, img3x1, img3x2, img3x3, img3x4, img4x1, img4x2, img4x3, img4x4));

        /**
         * puzzle - д байрлуулах зургуудыг resource - оос уншиж авна.
         */
        imgList = new ArrayList<>();
        for (int i = 1; i <= PUZZLE_SIZE*PUZZLE_SIZE; i++) {
            Image image = new Image("file:src/main/resources/images/" + i + ".jpg");
            imgList.add(image);
        }

        int itr = 0;
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            for (int j = 0; j < PUZZLE_SIZE; j++) {
                if (puzzleModel.getBoardAt(i, j) != null) {
                    int boardAt = puzzleModel.getBoardAt(i, j);
                    ivList.get(itr++).setImage(imgList.get(boardAt - 1));
                } else {
                    ivList.get(itr++).setImage(null);
                }
            }
        }

        mainEvent();

    }

    public void mainEvent() {
        for (int i = 0; i < PUZZLE_SIZE*PUZZLE_SIZE; i++) {
            doneAndDetectedEvent(ivList.get(i), i);
            setDragDroppedEvent(ivList.get(i));
            setOnDragOverEvent(ivList.get(i));
        }
    }

    public void doneAndDetectedEvent(ImageView iv, int indx) {
        iv.setOnDragDetected((MouseEvent event) -> {
            Cell moveToPoint = null;
            try {
                moveToPoint = puzzleModel.moveToEmptyField(indx / PUZZLE_SIZE, indx % PUZZLE_SIZE);
                System.out.println("moveToPoint: " + moveToPoint);
            } catch (Exception e) {}
            if (moveToPoint != null) {
                Dragboard db = iv.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putImage(iv.getImage());
                db.setContent(content);
                event.consume();
            }
        });
    }

    public void setDragDroppedEvent(ImageView iv) {
        iv.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasImage() && iv.getImage() == (null)) {
                iv.setImage(db.getImage());
                String sour = iv.toString().split("=")[1].split(",")[0];
                String res = event.getGestureSource().toString().split("=")[1].split(",")[0];
                clearResource(res);

                int resIndx = Integer.parseInt(res.replaceAll("[^0-9]", "")) - 1;
                int sourIndx = Integer.parseInt(sour.replaceAll("[^0-9]", "")) - 1;

                puzzleModel.switchEmptyField(sourIndx / PUZZLE_SIZE, sourIndx % PUZZLE_SIZE, resIndx / PUZZLE_SIZE, resIndx % PUZZLE_SIZE);

                if(puzzleModel.areBoardsEqual()) {
                    puzzleStatusLbl.setText("SOLVED");
                    puzzleStatusLbl.setTextFill(Color.GREEN);
                    img4x4.setImage(new Image("file:src/main/resources/images/img.png"));
                }
            }
            event.consume();
        });
    }

    public void setOnDragOverEvent(ImageView iv) {
        iv.setOnDragOver(event -> {
            if (event.getGestureSource() != iv && event.getDragboard().hasImage()) {
                event.acceptTransferModes(TransferMode.ANY);
            }
            event.consume();
        });
    }

    public void clearResource(String res) {
        if (res.equals("img1x1")) {
            img1x1.setImage(null);
        } else if (res.equals("img1x2")) {
            img1x2.setImage(null);
        } else if (res.equals("img1x3")) {
            img1x3.setImage(null);
        } else if (res.equals("img1x4")) {
            img1x4.setImage(null);
        } else if (res.equals("img2x1")) {
            img2x1.setImage(null);
        } else if (res.equals("img2x2")) {
            img2x2.setImage(null);
        } else if (res.equals("img2x3")) {
            img2x3.setImage(null);
        } else if (res.equals("img2x4")) {
            img2x4.setImage(null);
        } else if (res.equals("img3x1")) {
            img3x1.setImage(null);
        } else if (res.equals("img3x2")) {
            img3x2.setImage(null);
        } else if (res.equals("img3x3")) {
            img3x3.setImage(null);
        } else if (res.equals("img3x4")) {
            img3x4.setImage(null);
        } else if (res.equals("img4x1")) {
            img4x1.setImage(null);
        } else if (res.equals("img4x2")) {
            img4x2.setImage(null);
        } else if (res.equals("img4x3")) {
            img4x3.setImage(null);
        } else if (res.equals("img4x4")) {
            img4x4.setImage(null);
        }
    }

    @FXML
    void shuffle(ActionEvent event) {
        puzzleModel = new Puzzle(PUZZLE_SIZE);
    }
}
