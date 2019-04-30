package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import java.awt.*;

public class UpdateProductController {
    @FXML private TextField nameTxtField;
    @FXML private TextField priceTxtField;
    @FXML private TextField quantityTxtField;
    @FXML private TextArea descriptionTxtArea;
    @FXML private MenuButton categoryMenuBtn;
    @FXML private TableView updateProductTable;


    public void cancel(ActionEvent event) {
    }

    public void confirm(ActionEvent event) {
    }

    public void updateProduct(ActionEvent event) {
    }

    public void refreshProducts(ActionEvent event) {
    }
}
