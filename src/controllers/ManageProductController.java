package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static commonFunctions.GeneralCommonFunctions.openNewScene;
import static commonFunctions.GeneralCommonFunctions.openNewStage;

public class ManageProductController {
    @FXML private AnchorPane productManage;

    public void addProductView(ActionEvent event) throws IOException {
        openNewStage(this.getClass(),"../view/product_add.fxml","Add Product");
    }

    public void updateProductView(ActionEvent event) throws IOException {
        openNewStage(this.getClass(),"../view/product_update.fxml","Update Product");

    }

    public void deleteProductView(ActionEvent event) throws IOException {
        openNewStage(this.getClass(),"../view/product_delete.fxml","Delete product");

    }

    public void sreachProductView(ActionEvent event) throws IOException {
        openNewStage(this.getClass(),"../view/product_search.fxml","Search Product");

    }

    public void mainMenu(ActionEvent event) throws IOException {
        openNewScene(this.getClass(),productManage,"../view/menu_main.fxml","Manage product");

    }
}
