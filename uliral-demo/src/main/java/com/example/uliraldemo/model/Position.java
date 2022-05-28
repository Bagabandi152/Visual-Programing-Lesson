package com.example.uliraldemo.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Bagaa
 * @project uliral-demo
 * @created 28/05/2022 - 12:00 PM
 * @purpose
 * @definition
 */
public class Position {
    private final StringProperty positionName;
    private final IntegerProperty positionID;

    public Position(int departmentId, String departmentName) {
        this.positionName = new SimpleStringProperty(departmentName);
        this.positionID = new SimpleIntegerProperty(departmentId);
    }

    public int getPositionID() {
        return positionID.get();
    }

    public IntegerProperty positionIDProperty() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID.set(positionID);
    }

    public String getPositionName() {
        return positionName.get();
    }

    public StringProperty positionNameProperty() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName.set(positionName);
    }
}
