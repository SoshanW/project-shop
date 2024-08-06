package com.dev.pos.controller;

import com.dev.pos.dao.DatabaseAccessCode;
import com.dev.pos.db.DBConnection;
import com.dev.pos.dto.UserDTO;
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
import javafx.stage.Window;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private AnchorPane context;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        try{
            UserDTO user = DatabaseAccessCode.findUser(txtEmail.getText());

            if (user!=null){
            if(PasswordManager.checkPassword(txtPassword.getText(), user.getPassword())){
                setUi("DashboardForm");
            }else {
                new Alert(Alert.AlertType.INFORMATION, "User Not Found...!").show();
            }
            }

        }catch(ClassNotFoundException | SQLException | IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
        setUi("SignUp");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }

}
