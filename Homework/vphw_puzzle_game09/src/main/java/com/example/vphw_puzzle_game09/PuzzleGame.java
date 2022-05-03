package com.example.vphw_puzzle_game09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.PathTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class PuzzleGame extends Application {

    private Image image = new Image("https://assets.puzzlefactory.pl/puzzle/227/751/original.jpg",600,600,false,true);

    private static double SCENE_WIDTH = 1024;
    private static double SCENE_HEIGHT = 768;

    public static int TILE_ROW_COUNT = 5;
    public static int TILE_COLUMN_COUNT = 5;
    public static double TILE_SIZE = 120;

    public static double offsetX = (SCENE_WIDTH - TILE_ROW_COUNT * TILE_SIZE) / 2;
    public static double offsetY = (SCENE_HEIGHT - TILE_COLUMN_COUNT * TILE_SIZE) / 2;

    List<Cell> cells = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        for (int x = 0; x < TILE_ROW_COUNT; x++) {
            for (int y = 0; y < TILE_COLUMN_COUNT; y++) {

                ImageView tile = new ImageView(image);
                Rectangle2D rect = new Rectangle2D(TILE_SIZE * x, TILE_SIZE * y, TILE_SIZE, TILE_SIZE);
                tile.setViewport(rect);
                tile.setStyle("-fx-background-color: #000;");

                if (x == (TILE_ROW_COUNT - 1) && y == (TILE_COLUMN_COUNT - 1)) {
                    tile = null;
                }

                cells.add(new Cell(x, y, tile));
            }
        }

        shuffle();

        Pane pane = new Pane();

        for (int i = 0; i < cells.size(); i++) {

            Cell cell = cells.get(i);

            Node imageView = cell.getImageView();

            if (imageView == null)
                continue;

            imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

                moveCell((Node) mouseEvent.getSource());

            });

            imageView.relocate(cell.getLayoutX(), cell.getLayoutY());

            pane.getChildren().add(cell.getImageView());
        }

        pane.setStyle("-fx-background-color: #d3d3d3;");

        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void shuffle() {

        Random rnd = new Random();

        for (int i = 0; i < 1000; i++) {

            int a = rnd.nextInt(cells.size());
            int b = rnd.nextInt(cells.size());

            if (a == b)
                continue;

            if( cells.get(a).isEmpty() || cells.get(b).isEmpty())
                continue;

            swap( cells.get(a), cells.get(b));

        }

    }

    public void swap( Cell cellA, Cell cellB) {

        ImageView tmp = cellA.getImageView();
        cellA.setImageView(cellB.getImageView());
        cellB.setImageView(tmp);

    }

    public boolean checkSolved() {

        boolean allSolved = true;

        for (Cell cell : cells) {

            if (!cell.isSolved()) {
                allSolved = false;
                break;
            }
        }

        System.out.println("Solved: " + allSolved);

        return allSolved;
    }

    public void moveCell(Node node) {

        // get current cell using the selected node (imageview)
        Cell currentCell = null;
        for (Cell tmpCell : cells) {
            if (tmpCell.getImageView() == node) {
                currentCell = tmpCell;
                break;
            }
        }

        if (currentCell == null)
            return;

        // get empty cell
        Cell emptyCell = null;

        for (Cell tmpCell : cells) {
            if (tmpCell.isEmpty()) {
                emptyCell = tmpCell;
                break;
            }
        }

        if (emptyCell == null)
            return;

        int steps = Math.abs(currentCell.x - emptyCell.x) + Math.abs(currentCell.y - emptyCell.y);
        if (steps != 1)
            return;

        System.out.println("Transition: " + currentCell + " -> " + emptyCell);

        Path path = new Path();
        path.getElements().add(new MoveToAbs(currentCell.getImageView(), currentCell.getLayoutX(), currentCell.getLayoutY()));
        path.getElements().add(new LineToAbs(currentCell.getImageView(), emptyCell.getLayoutX(), emptyCell.getLayoutY()));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(100));
        pathTransition.setNode(currentCell.getImageView());
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);

        final Cell cellA = currentCell;
        final Cell cellB = emptyCell;
        pathTransition.setOnFinished(actionEvent -> {

            swap( cellA, cellB);

            checkSolved();

        });

        pathTransition.play();

    }

    private static class Cell {

        int x;
        int y;

        ImageView initialImageView;
        ImageView currentImageView;

        public Cell(int x, int y, ImageView initialImageView) {
            super();
            this.x = x;
            this.y = y;
            this.initialImageView = initialImageView;
            this.currentImageView = initialImageView;
        }

        public double getLayoutX() {
            return x * TILE_SIZE + offsetX;
        }

        public double getLayoutY() {
            return y * TILE_SIZE + offsetY;
        }

        public ImageView getImageView() {
            return currentImageView;
        }

        public void setImageView(ImageView imageView) {
            this.currentImageView = imageView;
        }

        public boolean isEmpty() {
            return currentImageView == null;
        }

        public boolean isSolved() {
            return this.initialImageView == currentImageView;
        }

        @Contract(pure = true)
        public @NotNull String toString() {
            return "[" + x + "," + y + "]";
        }

    }

    public static class MoveToAbs extends MoveTo {

        public MoveToAbs(@NotNull Node node) {
            super(node.getLayoutBounds().getWidth() / 2, node.getLayoutBounds().getHeight() / 2);
        }

        public MoveToAbs(@NotNull Node node, double x, double y) {
            super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
        }

    }

    public static class LineToAbs extends LineTo {

        public LineToAbs(@NotNull Node node, double x, double y) {
            super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}