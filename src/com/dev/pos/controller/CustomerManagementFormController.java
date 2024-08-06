package com.dev.pos.controller;

import com.dev.pos.dao.DatabaseAccessCode;
import com.dev.pos.dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerManagementFormController {
    public TextField txtEmail;
    public TextField txtName;
    public TextField txtContact;
    public TextField txtSalary;
    public TextField txtSearchHere;
    public TableColumn colNo;
    public TableColumn colEmail;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colSalary;
    public AnchorPane context;
    public Button btnSaveOnAction;

    public void btnBackToHomeOnAction(ActionEvent actionEvent) throws IOException {

        setUI("LoginForm");
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        CustomerDTO dto = new CustomerDTO(
                txtEmail.getText(),
                txtName.getText(),
                txtContact.getText(),
                Double.valueOf(txtSalary.getText())
        );

        if (btnSaveOnAction.getText().equalsIgnoreCase("Save Customer")){
            CustomerDTO customer = DatabaseAccessCode.findCustomer(txtEmail.getText());
            if (customer.getEmail().equalsIgnoreCase(txtEmail.getText())){
                new Alert(Alert.AlertType.INFORMATION, "Customer is already saved...!").show();
            }else {
                boolean isSaved = DatabaseAccessCode.createCustomer(dto);
                if (isSaved){
                    new Alert(Alert.AlertType.INFORMATION, "Customer has been saved...!").show();
                    clearField();
                }else {
                    new Alert(Alert.AlertType.INFORMATION, "Something went wrong, Try Again...!").show();
                }
            }
        }
    }

    private void setUI(String location) throws IOException {

        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view"+location+".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }

    private void clearField(){
        txtEmail.clear();
        txtSalary.clear();
        txtContact.clear();
        txtName.clear();
    }
}
