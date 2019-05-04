package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import static commonFunctions.GeneralCommonFunctions.closeScene;

public class ManageOrderController {
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
}
