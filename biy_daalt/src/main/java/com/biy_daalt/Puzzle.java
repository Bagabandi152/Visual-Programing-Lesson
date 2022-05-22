package com.biy_daalt;

import java.util.*;
/**
 * @author Bagaa
 * @project biy_daalt
 * @created 22/05/2022 - 09:18 PM
 * @purpose
 * @definition
 */
public class Puzzle {
    private Integer[][] board;
    private Integer[][] expectedBoard;
    private int boardSize;

    private int[] indexX = {0, -1, 1, 0};
    private int[] indexY = {1, 0, 0, -1};

    public Puzzle(int size) {
        board = new Integer[size][size];
        expectedBoard = new Integer[size][size];

        boardSize = board.length;
        init();
    }

    private void init() {
        int counter = 1;
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                expectedBoard[x][y] = counter;
                board[x][y] = counter;
                counter++;
            }
        }

        expectedBoard[boardSize - 1][boardSize - 1] = null;
        board[boardSize - 1][boardSize - 1] = null;

        shuffleBoard();
    }

    public Cell moveToEmptyField(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (x == 0 && y != 0 && indexX[i] == -1) {
                if (board[x][y + indexY[i] - 1] == null) {
                    Cell point = new Cell(x, y + indexY[i] - 1);
                    return point;
                }
            } else {
                if (x + indexX[i] >= 0 && x + indexY[i] >= 0 && x + indexX[i] < boardSize && y + indexY[i] < boardSize) {
                    if (board[x + indexX[i]][y + indexY[i]] == null) {
                        Cell point = new Cell(x + indexX[i], y + indexY[i]);
                        return point;
                    }
                }
            }

        }
        return null;
    }

    public boolean areBoardsEqual() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                Integer expectedRec = expectedBoard[x][y];
                Integer rect = board[x][y];
                if (rect != expectedRec || !(expectedRec == rect || expectedRec.toString().equals(rect.toString()))) {
                    return false;
                }
            }
        }
        return true;
    }

    private void shuffleBoard() {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 1; i < boardSize * boardSize; i++) {
            randomList.add(i);
        }

        randomList.add(null);
        Collections.shuffle(randomList);
        int counter = 0;
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                board[x][y] = randomList.get(counter++);
            }
        }
    }

    public void switchEmptyField(int x, int y, int x1, int y1) {
        board[x][y] = board[x1][y1];
        board[x1][y1] = null;
    }

    public Integer getBoardAt(int x, int y) {
        if (x < boardSize && x >= 0 && y < boardSize && y >= 0) {
            return board[x][y];
        }
        return null;
    }
}


