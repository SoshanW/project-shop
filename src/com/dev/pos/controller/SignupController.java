package com.dev.pos.controller;

import com.dev.pos.dao.DatabaseAccessCode;
import com.dev.pos.db.DBConnection;
import com.dev.pos.util.security.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class SignupController {

    @FXML
    private AnchorPane context;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnAlreadyHaveAnAccountOnAction(ActionEvent event) throws IOException {
        setUi("LoginForm");
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        try{
            boolean isSaved = DatabaseAccessCode.createUser(txtEmail.getText(), txtPassword.getText().trim());
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION, "User Has Been Saved...!").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION, "User Not Found...!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }


}

