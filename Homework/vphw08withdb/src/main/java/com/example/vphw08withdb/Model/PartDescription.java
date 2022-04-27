package com.example.vphw08withdb.Model;

public class PartDescription {
    private long ID;
    private int yr;
    private String mk;
    private String mdl;
    private String cat;
    private String name;
    private double price;

    public PartDescription(long ID, int yr, String mk, String mdl, String cat, String name, double price) {
        this.ID = ID;
        this.yr = yr;
        this.mk = mk;
        this.mdl = mdl;
        this.cat = cat;
        this.name = name;
        this.price = price;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getYr() {
        return yr;
    }

    public void setYr(int yr) {
        this.yr = yr;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getMdl() {
        return mdl;
    }

    public void setMdl(String mdl) {
        this.mdl = mdl;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return this.ID + " " + this.yr + " " + this.mk + " " + this.mdl + " " + this.cat + " " + this.name + " " + this.price;
    }

}
