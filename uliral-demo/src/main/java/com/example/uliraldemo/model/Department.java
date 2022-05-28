package com.example.uliraldemo.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Bagaa
 * @project uliral-demo
 * @created 28/05/2022 - 11:59 AM
 * @purpose
 * @definition
 */
public class Department {
    private final StringProperty departmentName;
    private final IntegerProperty departmentId;

    public Department(int departmentId, String departmentName) {
        this.departmentName = new SimpleStringProperty(departmentName);
        this.departmentId = new SimpleIntegerProperty(departmentId);
    }

    public int getDepartmentID() {
        return departmentId.get();
    }

    public IntegerProperty departmentIDProperty() {
        return departmentId;
    }

    public void setDepartmentID(int departmentId) {
        this.departmentId.set(departmentId);
    }

    public String getDepartmentName() {
        return departmentName.get();
    }

    public StringProperty departmentNameProperty() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName.set(departmentName);
    }
}
