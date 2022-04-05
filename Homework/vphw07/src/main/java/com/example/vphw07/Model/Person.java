package com.example.vphw07.Model;

import javafx.scene.paint.Color;

public class Person {
    private String fullName;
    private Color favColor;
    private String favSport;
    private String years;
    private boolean vegetarian;

    public Person(String fullName, Color favColor, String favSport, String years, boolean vegetarian) {
        this.fullName = fullName;
        this.favColor = favColor;
        this.favSport = favSport;
        this.years = years;
        this.vegetarian = vegetarian;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Color getFavColor() {
        return favColor;
    }

    public void setFavColor(Color favColor) {
        this.favColor = favColor;
    }

    public String getFavSport() {
        return favSport;
    }

    public void setFavSport(String favSport) {
        this.favSport = favSport;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}
