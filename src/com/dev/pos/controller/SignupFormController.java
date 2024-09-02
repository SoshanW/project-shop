package com.dev.pos.controller;

import com.dev.pos.dao.DatabaseAccessCode;
import com.dev.pos.db.DBConnection;
import com.dev.pos.dto.UserDTO;
import com.dev.pos.util.security.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupFormController {
    public AnchorPane context;
    public TextField txtEmail;
    public PasswordField txtPassword;


    private void setUI(String location) throws IOException {
        Stage stage=(Stage)context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }

    public void btnSignupOnAction(ActionEvent actionEvent) {

        try {

            UserDTO userDTO = new UserDTO(txtEmail.getText(),txtPassword.getText().trim());
            boolean isSaved = new DatabaseAccessCode().createUser(userDTO);
            if(isSaved){
                new Alert(Alert.AlertType.INFORMATION,"User has been saved...!").show();
                setUI("LoginForm");
            }else {
                new Alert(Alert.AlertType.INFORMATION,"User Not Found...!").show();
            }

        }catch (SQLException | ClassNotFoundException | IOException e){
            e.printStackTrace();
        }

    }

    public void btnAlreadyHaveAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm");
    }
}