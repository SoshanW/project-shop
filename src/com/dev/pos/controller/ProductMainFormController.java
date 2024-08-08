package com.dev.pos.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {
    }

    public void btnNewProductOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnNewBatchOnAction(ActionEvent actionEvent) {
    }
}
