package controllers;

import db.ProductDBOperation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.sql.SQLException;

import static commonFunctions.GeneralCommonFunctions.closeScene;

public class AddProductController{
    @FXML private AnchorPane productAdd;
    @FXML private TextField nameTxtView;
    @FXML private TextField priceTxtView;
    @FXML private TextField quantityTxtView;
    @FXML private TextArea descriptionTxtArea;
    @FXML private MenuButton categoryMenuBtn;
    @FXML private MenuItem technologyItem;
    @FXML private MenuItem helthyItem;
    @FXML private MenuItem industryItem;
    @FXML private MenuItem kitchenItem;
    private String itemSelected="";


    @FXML
    public void cancel(ActionEvent event) {
        closeScene(productAdd);
    }

    @FXML
    public void addProduct(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        ProductDBOperation.addProduct(nameTxtView,itemSelected,priceTxtView,quantityTxtView,descriptionTxtArea);

    }

    @FXML
    public void chooseCategory(ActionEvent event) {
        MenuItem selected =(MenuItem) event.getSource();
        itemSelected=selected.getText();
        categoryMenuBtn.setText(itemSelected);
        }
}
