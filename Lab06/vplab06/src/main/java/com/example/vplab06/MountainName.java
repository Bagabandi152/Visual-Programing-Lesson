package com.example.vplab06;

public class MountainName {
    private int key;
    public String name;

    MountainName(int _key, String _name){
        key = _key;
        name = _name;
    }

    int getKey(){
        return key;
    }

    String getName(){
        return name;
    }

    void setName(String _name){
        name = _name;
    }
}
