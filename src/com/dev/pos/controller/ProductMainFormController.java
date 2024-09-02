package com.dev.pos.controller;

import com.dev.pos.dao.DatabaseAccessCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ProductMainFormController {
    public AnchorPane context;
    public TextField txtProductCode;
    public TextArea txtDescription;
    public Button btnSave;
    public TextField txtSearch;
    public TableView tblProduct;
    public TableColumn colProductID;
    public TableColumn colDescription;
    public TableColumn colShowMore;
    public TableColumn colDelete;
    public TextField txtSelectedProductCode;
    public TextArea txtSelectedDescription;
    public TableView tblProductMain;
    public TableColumn colMainCode;
    public TableColumn colQTY;
    public TableColumn colBuyingPrice;
    public TableColumn colDAvailability;
    public TableColumn colMainShowPrice;
    public TableColumn colSellingPrice;
    public TableColumn colMainDelete;

    public void initialize(){loadProductId();}

    private void loadProductId(){
        try{
            txtProductCode.setText(String.valueOf(new DatabaseAccessCode().getLastProductID()));
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {
    }

    public void btnNewProductOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnNewBatchOnAction(ActionEvent actionEvent) {
    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }
}
