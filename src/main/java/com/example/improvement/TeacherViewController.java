package com.example.improvement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class TeacherViewController {
    @FXML
    private TextField nameField;
    @FXML
    private TableView<Course> courseTable;
    @FXML
    private TableColumn<Course, String> coursecodecolumn;

    @FXML
    private TableColumn<Course, String> coursenamecolumn;

    @FXML
    private TableColumn<Course, Void> gradecolumn;

    public void initialize(){
        coursecodecolumn.setCellValueFactory(cellData -> cellData.getValue().courseCode);
        coursenamecolumn.setCellValueFactory(cellData -> cellData.getValue().courseName);
        gradecolumn.setCellFactory(col -> new TableCell<>() {
            private final Button button = new Button("Grades");
            {
                button.setOnAction(e -> {
                    String courseCode = String.valueOf(getTableView().getItems().get(getIndex()).courseCode);
                    System.out.println("Clicked: " + courseCode);
                });
            }

            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if(empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });

        User loggedIn =  Database.loggedIn;
        nameField.setText(loggedIn.username);
        List<Course> courses = Database.getCourseTeacher(loggedIn.UID);
        for(Course e:courses){
            System.out.println(e);
            courseTable.getItems().add(e);
        }

    }




}
