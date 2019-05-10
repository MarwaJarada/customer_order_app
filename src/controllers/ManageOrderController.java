package controllers;

import db.CustomerDBOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static commonFunctions.CustomerCommonFunctions.showCustomersInMenuBtn;
import static commonFunctions.GeneralCommonFunctions.closeScene;
import static commonFunctions.ProductCommonFunction.showProductsInMenuBtn;

public class ManageOrderController implements Initializable {
    @FXML private MenuButton customerMenuBtn;
    @FXML private MenuButton productMenuBtn;
    @FXML private TextField quantityTxtField;
    @FXML private TextField orderDateTxtField;
    @FXML private AnchorPane orderManage;

    public void insertOrder(ActionEvent event) {
    }

    public void showOrders(ActionEvent event) {
    }

    public void cancel(ActionEvent event) {
        closeScene(orderManage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showCustomersInMenuBtn(customerMenuBtn);
            showProductsInMenuBtn(productMenuBtn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
