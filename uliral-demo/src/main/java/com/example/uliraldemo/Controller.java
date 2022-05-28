package com.example.uliraldemo;

import com.example.uliraldemo.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class Controller {
    public MainApp main;

    boolean addNewClicked = false;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField mobileField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nickNameField;

    @FXML
    private TextField facebookUrlField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField lineIDField;

    @FXML
    private ComboBox<String> positionCombo;

    @FXML
    private ComboBox<String> departmentCombo;

    @FXML
    private TextArea noteField;

    @FXML
    private ImageView profile;

    @FXML
    private TableView<Employee> infoTable;

    @FXML
    private TableColumn<Employee, String> colFullName;

    @FXML
    private TableColumn<Employee, String> colNickName;

    @FXML
    private TableColumn<Employee, Number> colPosition;

    @FXML
    private TableColumn<Employee, Number> colDepartment;

    @FXML
    private TableColumn<Employee, String> colMobile;

    @FXML
    private TableColumn<Employee, String> colPhone;

    @FXML
    void handleAddNew(ActionEvent event) {
        showEmployeeDetail(null);
        addNewClicked = true;
    }

    @FXML
    void handleBrowse(ActionEvent event) {

    }

    @FXML
    void handleCancel(ActionEvent event) {
        showEmployeeDetail(null);
    }

    @FXML
    void handleDelete(ActionEvent event) {

    }

    @FXML
    void handleSave(ActionEvent event) {
        if (addNewClicked){
            Employee newEmp =  new Employee(
                    fullNameField.getText(),
                    nickNameField.getText(),
                    Integer.parseInt(positionCombo.getValue()),
                    Integer.parseInt(departmentCombo.getValue()),
                    mobileField.getText(),
                    phoneField.getText(),
                    emailField.getText(),
                    facebookUrlField.getText(),
                    lineIDField.getText(),
                    noteField.getText()
            );
            main.getEmployees().add(newEmp);
        }else {
            Employee tempEmp = getSelectedEmployee();

            tempEmp.setFullName(fullNameField.getText());
            tempEmp.setNickName(nickNameField.getText());
            tempEmp.setEmail(emailField.getText());
            tempEmp.setDepartmentId(Integer.parseInt(departmentCombo.getValue()));
            tempEmp.setFacebookUrl(facebookUrlField.getText());
            tempEmp.setMobile(mobileField.getText());
            tempEmp.setPhoneExt(phoneField.getText());
            tempEmp.setLineId(lineIDField.getText());
            tempEmp.setPositionId(Integer.parseInt(positionCombo.getValue()));
            tempEmp.setNote(noteField.getText());
        }

    }

    public Employee getSelectedEmployee(){
        return infoTable.getSelectionModel().getSelectedItem();
    }

    public void setMain(MainApp main) {
        this.main = main;
        infoTable.setItems(main.getEmployees());
        positionCombo.setItems(main.getPositions());
        departmentCombo.setItems(main.getDepartments());
    }

    private void showEmployeeDetail(Employee employee) {
        addNewClicked = false;
        if (employee != null) {
            fullNameField.setText(employee.getFullName());
            nickNameField.setText(employee.getNickName());
            mobileField.setText(String.valueOf(employee.getMobile()));
            phoneField.setText(String.valueOf(employee.getPhoneExt()));
            emailField.setText(employee.getEmail());
            facebookUrlField.setText(employee.getFacebookUrl());
            lineIDField.setText(employee.getLineId());
            noteField.setText(employee.getNote());
            positionCombo.setPromptText(Integer.toString(employee.getPositionId()));
            departmentCombo.setPromptText(Integer.toString(employee.getDepartmentId()));
        } else {
            fullNameField.setText("");
            nickNameField.setText("");
            mobileField.setText("");
            phoneField.setText("");
            emailField.setText("");
            facebookUrlField.setText("");
            lineIDField.setText("");
            noteField.setText("");
            positionCombo.setPromptText("");
            departmentCombo.setPromptText("");
        }
    }


    @FXML
    void initialize(){
        colFullName.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
        colDepartment.setCellValueFactory(cellData -> cellData.getValue().departmentIdProperty());
        colNickName.setCellValueFactory(cellData -> cellData.getValue().nickNameProperty());
        colMobile.setCellValueFactory(cellData -> cellData.getValue().mobileProperty());
        colPosition.setCellValueFactory(cellData -> cellData.getValue().positionIdProperty());
        colPhone.setCellValueFactory(cellData -> cellData.getValue().phoneExtProperty());

        showEmployeeDetail(null);

        infoTable.getSelectionModel().selectedItemProperty().addListener(
                (observable , oldValue , newValue) -> showEmployeeDetail(newValue)
        );
    }
}