package com.example.improvement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button btnSignIn;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfUser;
    @FXML
    private Text textWarning;

    public void initialize(){
        btnSignIn.setOnAction(actionEvent -> {
            String password = tfPassword.getText().trim();
            String user = tfUser.getText().trim();
           if(user.isEmpty() || password.isEmpty()){
               promptWarning("Fields cannot be empty");
               return;
           }
            if(Database.checkPass(user, password)){
                Session.save(Database.loggedIn);
                if(Database.loggedIn.role == 0){
                    changeToStudent();
                }else{
                    changeToTeacher();
                }
            }else{
                promptWarning("Invalid Credentials");
            }

        });
    }

    public void promptWarning(String message){
        textWarning.setText(message);
    }
    public void changeToStudent(){
        Stage stage = (Stage) tfUser.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("studentview.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 500, 329);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Student!");
        stage.setScene(scene);
        stage.show();
    }
    public void changeToTeacher(){
        Stage stage = (Stage) tfUser.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("teacherview.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 500, 329);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Teacher!");
        stage.setScene(scene);
        stage.show();
    }

}
