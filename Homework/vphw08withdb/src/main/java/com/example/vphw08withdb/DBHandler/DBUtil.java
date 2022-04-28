package com.example.vphw08withdb.DBHandler;

import com.example.vphw08withdb.Model.PartDescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
    private Connection connDB;

    public DBUtil(){
        try {
            connDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/college_park_auto_parts","root","root");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnDB() {
        return connDB;
    }

    public ObservableList<PartDescription> getPartList(){
        ObservableList<PartDescription> personList = FXCollections.observableArrayList();
        String query = "SELECT * FROM People ";
        Statement st;
        ResultSet rs;

        try {
            st = connDB.createStatement();
            rs = st.executeQuery(query);
            PartDescription partDescription;
            while(rs.next()) {
                partDescription = new PartDescription(rs.getLong("partNumber"), rs.getInt("year"), rs.getString("make"), rs.getString("model"),rs.getString("category"), rs.getString("name"), rs.getDouble("price"));
                personList.add(partDescription);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personList;
    }

    public void executeQuery(String query) {
        Statement st;
        try {
            st = connDB.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
