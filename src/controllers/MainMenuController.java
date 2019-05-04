package controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

import static commonFunctions.GeneralCommonFunctions.closeScene;
import static commonFunctions.GeneralCommonFunctions.openNewScene;
import static commonFunctions.GeneralCommonFunctions.openNewStage;

public class MainMenuController{
    @FXML AnchorPane mainMenu;

    public void openManageProductView(ActionEvent event) throws IOException {
        openNewScene(this.getClass(),mainMenu,"../view/product_manage.fxml");

    }

    @FXML
    public void openManageCustomerView(ActionEvent event) throws IOException {
        openNewScene(this.getClass(),mainMenu,"../view/customer_manage.fxml");
    }

    public void openManageOrderView(ActionEvent event) throws IOException {
        openNewStage(this.getClass(),"../view/order_manage.fxml");
        //openNewScene(this.getClass(),mainMenu,"../view/order_manage.fxml");

    }

    public void logout(ActionEvent event) throws IOException {
        openNewScene(this.getClass(),mainMenu,"../view/screen_login.fxml");
    }

}
