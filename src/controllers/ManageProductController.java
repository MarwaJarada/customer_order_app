package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static commonFunctions.GeneralCommonFunctions.openNewScene;

public class ManageProductController {
    @FXML private AnchorPane productManage;

    public void addProductView(ActionEvent event) {
    }

    public void updateProductView(ActionEvent event) {
    }

    public void deleteProductView(ActionEvent event) {
    }

    public void sreachProductView(ActionEvent event) {
    }

    public void mainMenu(ActionEvent event) throws IOException {
        openNewScene(this.getClass(),productManage,"../view/menu_main.fxml");

    }
}
