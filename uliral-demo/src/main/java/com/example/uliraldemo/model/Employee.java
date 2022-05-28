package com.example.uliraldemo.model;

/**
 * @author Bagaa
 * @project uliral-demo
 * @created 28/05/2022 - 11:57 AM
 * @purpose
 * @definition
 */
import javafx.beans.property.*;

public class Employee {

    private final StringProperty fullName;
    private final StringProperty nickName;
    private final IntegerProperty positionId;
    private final IntegerProperty departmentId;
    private final StringProperty mobile;
    private final StringProperty phoneExt;
    private final StringProperty email;
    private final StringProperty facebookUrl;
    private final StringProperty lineId;
    private final StringProperty note;

    public Employee(String fullName, String nickName, int positionId,
                    int departmentId, String mobile,
                    String phoneExt, String email,
                    String facebookUrl, String lineId, String note) {
        this.fullName = new SimpleStringProperty(fullName);
        this.nickName = new SimpleStringProperty(nickName);
        this.positionId = new SimpleIntegerProperty(positionId);
        this.departmentId = new SimpleIntegerProperty(departmentId);
        this.mobile = new SimpleStringProperty(mobile);
        this.phoneExt = new SimpleStringProperty(phoneExt);
        this.email = new SimpleStringProperty(email);
        this.facebookUrl = new SimpleStringProperty(facebookUrl);
        this.lineId = new SimpleStringProperty(lineId);
        this.note = new SimpleStringProperty(note);
    }

    public String getNote() {
        return note.get();
    }

    public StringProperty noteProperty() {
        return note;
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    public String getLineId() {
        return lineId.get();
    }

    public StringProperty lineIdProperty() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId.set(lineId);
    }

    public String getFacebookUrl() {
        return facebookUrl.get();
    }

    public StringProperty facebookUrlProperty() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl.set(facebookUrl);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhoneExt() {
        return phoneExt.get();
    }

    public StringProperty phoneExtProperty() {
        return phoneExt;
    }

    public void setPhoneExt(String phoneExt) {
        this.phoneExt.set(phoneExt);
    }

    public String getMobile() {
        return mobile.get();
    }

    public StringProperty mobileProperty() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile.set(mobile);
    }

    public int getDepartmentId() {
        return departmentId.get();
    }

    public IntegerProperty departmentIdProperty() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId.set(departmentId);
    }

    public int getPositionId() {
        return positionId.get();
    }

    public IntegerProperty positionIdProperty() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId.set(positionId);
    }

    public String getNickName() {
        return nickName.get();
    }

    public StringProperty nickNameProperty() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName.set(nickName);
    }

    public String getFullName() {
        return fullName.get();
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }
}

