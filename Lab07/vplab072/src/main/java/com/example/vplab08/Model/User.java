package com.example.vplab08.Model;

public class User {
    public String name;
    public String status;
    public String imgURL;

    public User(String name, String status, String imgURL) {
        this.name = name;
        this.status = status;
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
