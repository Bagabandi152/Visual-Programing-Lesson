package com.biy_daalt;

/**
 * @author Bagaa
 * @project biy_daalt
 * @created 22/05/2022 - 09:00 PM
 * @purpose puzzle - ийн нүдний байрлалыг хадгална.
 * @definition puzzle - ийн нүдний байрлалыг заана.
 */
public class Cell {
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x:" + x + " y:" + y;
    }
}

