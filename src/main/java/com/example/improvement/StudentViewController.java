package com.example.improvement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

public class StudentViewController {
    @FXML
    private TextField nameField;
    @FXML
    private TableView<Course> courseTable;
    @FXML
    private TableColumn<Course, String> coursecodecolumn;

    @FXML
    private TableColumn<Course, String> coursenamecolumn;

    @FXML
    private TableColumn<Course, Number> gradecolumn;

    public void initialize(){
        coursecodecolumn.setCellValueFactory(cellData -> cellData.getValue().courseCode);
        coursenamecolumn.setCellValueFactory(cellData -> cellData.getValue().courseName);
        gradecolumn.setCellValueFactory(cellData -> cellData.getValue().grade);

        User loggedIn =  Database.loggedIn;
        nameField.setText(loggedIn.username);
        List<Course> courses = Database.getCourse(loggedIn.UID);
        for(Course e:courses){
            System.out.println(e);
            courseTable.getItems().add(e);
        }
    }



}
