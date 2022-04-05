package com.example.vpexam01;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private TextField attEg;

    @FXML
    private TableColumn<String, String> attEgCol;

    @FXML
    private TextField attPer;

    @FXML
    private TextField attScore;

    @FXML
    private TableColumn<String, String> attScoreCol;

    @FXML
    private Button clearAll;

    @FXML
    private Button computeGrades;

    @FXML
    private Button deleteRecord;

    @FXML
    private Button endPos;

    @FXML
    private Button exitProgram;

    @FXML
    private TextField fname;

    @FXML
    private TableColumn<String, String> fnameCol;

    @FXML
    private TextField lname;

    @FXML
    private TableColumn<String, String> lnameCol;

    @FXML
    private Button loadStudents;

    @FXML
    private Button nextPos;

    @FXML
    private TextField pqEg;

    @FXML
    private TextField pqPer;

    @FXML
    private TextField pqScore;

    @FXML
    private TextField preExamEg;

    @FXML
    private TextField preExamPer;

    @FXML
    private TextField preExamScore;

    @FXML
    private TextField preGrade;

    @FXML
    private TableColumn<String, String> preGradeCol;

    @FXML
    private Button prePos;

    @FXML
    private TextField proEg;

    @FXML
    private TableColumn<String, String> proEgCol;

    @FXML
    private TextField proPer;

    @FXML
    private TextField proScore;

    @FXML
    private TableColumn<String, String>proScoreCol;

    @FXML
    private TextField remarks;

    @FXML
    private Button saveRecord;

    @FXML
    private Button showDetails;

    @FXML
    private Button startPos;

    @FXML
    private TableColumn<String, String> stuIdcol;

    @FXML
    private TextField studentid;

    @FXML
    private TableView<Student> tvStudents;

    @FXML
    private Button updateRecord;

    @FXML
    private TextField wqEg;

    @FXML
    private TextField wqPer;

    @FXML
    private TextField wqScore;

    public List<Student> students = new ArrayList<Student>();

    @FXML
    void initialize() {
        tvStudents.getItems().addAll(students);
    }

    @FXML
    void clearAllGrades(ActionEvent event) {
        studentid.setText("");
        fname.setText("");
        lname.setText("");
        attScore.setText("");
        attEg.setText("");
        attPer.setText("");
        proScore.setText("");
        proEg.setText("");
        proPer.setText("");
        wqScore.setText("");
        wqEg.setText("");
        wqPer.setText("");
        preExamScore.setText("");
        preExamEg.setText("");
        preExamPer.setText("");
        pqScore.setText("");
        pqEg.setText("");
        pqPer.setText("");
        preGrade.setText("");
        remarks.setText("");
    }

    public void myCompute(String type , Integer score){
        byte totalScore;
        int eg;
        byte totalPercent;
        int percent;
        byte var8 = -1;

        switch(type.hashCode()) {
            case -1896237779:
                if (type.equals("Prelim")) {
                    var8 = 4;
                }
                break;
            case -1027294985:
                if (type.equals("Written")) {
                    var8 = 1;
                }
                break;
            case -404111607:
                if (type.equals("Attendance")) {
                    var8 = 0;
                }
                break;
            case 1355342585:
                if (type.equals("Project")) {
                    var8 = 3;
                }
                break;
            case 1382598133:
                if (type.equals("Practical")) {
                    var8 = 2;
                }
        }

        switch(var8) {
            case 0:
                totalScore = 20;
                totalPercent = 10;
                eg = score * 100 / totalScore;
                percent = eg * totalPercent / 100;
                attEg.setText(String.valueOf(eg));
                attPer.setText(String.valueOf(percent));
                break;
            case 1:
                totalScore = 50;
                totalPercent = 10;
                eg = score * 100 / totalScore;
                percent = eg * totalPercent / 100;
                this.wqEg.setText(String.valueOf(eg));
                this.wqPer.setText(String.valueOf(percent));
                break;
            case 2:
                totalScore = 50;
                totalPercent = 20;
                eg =  score * 100 / totalScore;
                percent = eg * totalPercent / 100;
                this.pqEg.setText(String.valueOf(eg));
                this.pqPer.setText(String.valueOf(percent));
                break;
            case 3:
                totalScore = 100;
                totalPercent = 30;
                eg =  score * 100 / totalScore;
                percent = eg * totalPercent / 100;
                this.proEg.setText(String.valueOf(eg));
                this.proPer.setText(String.valueOf(percent));
                break;
            case 4:
                totalScore = 100;
                totalPercent = 30;
                eg =  score * 100 / totalScore;
                percent = eg * totalPercent / 100;
                this.preExamEg.setText(String.valueOf(eg));
                this.preExamPer.setText(String.valueOf(percent));
        }
    }

    @FXML
    void compute(ActionEvent event) {
        myCompute("Attendance" , Integer.parseInt(attScore.getText()));
        myCompute("Written" , Integer.parseInt(wqScore.getText()));
        myCompute("Practical" , Integer.parseInt(pqScore.getText()));
        myCompute("Project" , Integer.parseInt(proScore.getText()));
        myCompute("Prelim" , Integer.parseInt(preExamScore.getText()));
        int prelimGrade = Integer.parseInt(attPer.getText()) + Integer.parseInt(wqPer.getText()) + Integer.parseInt(pqPer.getText()) + Integer.parseInt(proPer.getText()) + Integer.parseInt(preExamPer.getText());
        preGrade.setText(String.valueOf(prelimGrade));
        if (prelimGrade > 90){
            remarks.setText("Passed");
        }else{
            remarks.setText("Failed");
        }
    }

    @FXML
    void delete(ActionEvent event) {
        students.forEach(student -> {
            if(student.getStudid() == Integer.parseInt(studentid.toString())){
                students.remove(student);
            }
        });
    }

    @FXML
    void end(ActionEvent event) {
        studentid.setText(Integer.toString(students.get(students.size() - 1).getStudid()));
        fname.setText(students.get(students.size() - 1).getFname());
        lname.setText(students.get(students.size() - 1).getLname());
        attScore.setText(Integer.toString(students.get(students.size() - 1).getAttScore()));
        proScore.setText(Integer.toString(students.get(students.size() - 1).getProScore()));
        wqScore.setText(Integer.toString(students.get(students.size() - 1).getWqScore()));
        preExamScore.setText(Integer.toString(students.get(students.size() - 1).getPreScore()));
        pqScore.setText(Integer.toString(students.get(students.size() - 1).getPqScore()));
        preGrade.setText(Double.toString(students.get(students.size() - 1).getPreGrade()));
        remarks.setText(students.get(students.size() - 1).getRemarks());
    }

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void load(ActionEvent event) {

    }

    @FXML
    void next(ActionEvent event) {

    }

    @FXML
    void pre(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {
        students.add(new Student(Integer.parseInt(studentid.toString()), fname.toString(), lname.toString(), Integer.parseInt(attScore.toString()), Integer.parseInt(proScore.toString()),Integer.parseInt(wqScore.toString()), Integer.parseInt(preExamScore.toString()),Integer.parseInt(pqScore.toString()), Double.parseDouble(preGrade.toString()), remarks.toString()));
    }

    @FXML
    void show(ActionEvent event) {

    }

    @FXML
    void start(ActionEvent event) {
        studentid.setText(Integer.toString(students.get(0).getStudid()));
        fname.setText(students.get(0).getFname());
        lname.setText(students.get(0).getLname());
        attScore.setText(Integer.toString(students.get(0).getAttScore()));
        proScore.setText(Integer.toString(students.get(0).getProScore()));
        wqScore.setText(Integer.toString(students.get(0).getWqScore()));
        preExamScore.setText(Integer.toString(students.get(0).getPreScore()));
        pqScore.setText(Integer.toString(students.get(0).getPqScore()));
        preGrade.setText(Double.toString(students.get(0).getPreGrade()));
        remarks.setText(students.get(0).getRemarks());
    }

    @FXML
    void update(ActionEvent event) {

    }

}
