package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static commonFunctions.GeneralCommonFunctions.openNewScene;
import static commonFunctions.GeneralCommonFunctions.openNewStage;

public class ManageCustomerController {
    @FXML private AnchorPane customerManage;

    public void openAddCustomerView(ActionEvent event) throws IOException {
        openNewStage(this.getClass(),"../view/customer_add.fxml","Add Customer");
    }

    public void openUpdateCustomerView(ActionEvent event) throws IOException {
        openNewStage(this.getClass(),"../view/customer_update.fxml","Update Customer");


    }

    public void openDeleteCutomerView(ActionEvent event) throws IOException {
        openNewStage(this.getClass(),"../view/customer_delete.fxml","Delete Customer");

    }

    public void mainMenu(ActionEvent event) throws IOException {
        openNewScene(this.getClass(),customerManage,"../view/menu_main.fxml","Main Menu");

    }
}
