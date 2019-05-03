package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static commonFunctions.GeneralCommonFunctions.openNewScene;

public class ManageCustomerController {
    @FXML private AnchorPane customerManage;

    public void openAddCustomerView(ActionEvent event) {
    }

    public void openUpdateCustomerView(ActionEvent event) {
    }

    public void openUpdateCutomerView(ActionEvent event) {

    }

    public void mainMenu(ActionEvent event) throws IOException {
        openNewScene(this.getClass(),customerManage,"../view/menu_main.fxml");

    }
}
