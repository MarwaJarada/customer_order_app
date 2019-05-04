package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import static commonFunctions.GeneralCommonFunctions.closeScene;

public class DeleteProductController {
    @FXML private TableView deleteProductTable;
    @FXML private AnchorPane productDelete;
    public void cancel(ActionEvent event) {
        closeScene(productDelete);
    }

    public void deleteProduct(ActionEvent event) {
    }

    public void refreshProducts(ActionEvent event) {
    }
}
