package com.example.vpexam01;

public class Student {
    public int studid;
    public String fname;
    public String lname;
    public int attScore;
    public int proScore;
    public int wqScore;
    public int preScore;
    public int pqScore;
    public double preGrade;
    public String remarks;

    public Student(int studid, String fname, String lname, int attScore, int proScore, int wqScore, int preScore, int pqScore, double preGrade, String remarks) {
        this.studid = studid;
        this.fname = fname;
        this.lname = lname;
        this.attScore = attScore;
        this.proScore = proScore;
        this.wqScore = wqScore;
        this.preScore = preScore;
        this.pqScore = pqScore;
        this.preGrade = preGrade;
        this.remarks = remarks;
    }

    public int getStudid() {
        return studid;
    }

    public void setStudid(int studid) {
        this.studid = studid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAttScore() {
        return attScore;
    }

    public void setAttScore(int attScore) {
        this.attScore = attScore;
    }

    public int getProScore() {
        return proScore;
    }

    public void setProScore(int proScore) {
        this.proScore = proScore;
    }

    public int getWqScore() {
        return wqScore;
    }

    public void setWqScore(int wqScore) {
        this.wqScore = wqScore;
    }

    public int getPreScore() {
        return preScore;
    }

    public void setPreScore(int preScore) {
        this.preScore = preScore;
    }

    public int getPqScore() {
        return pqScore;
    }

    public void setPqScore(int pqScore) {
        this.pqScore = pqScore;
    }

    public double getPreGrade() {
        return preGrade;
    }

    public void setPreGrade(double preGrade) {
        this.preGrade = preGrade;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
