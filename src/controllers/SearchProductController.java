package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import static commonFunctions.GeneralCommonFunctions.closeScene;

public class SearchProductController {
    @FXML private MenuButton categorymenuBtn;
    @FXML private TableView searchTable;
    @FXML private AnchorPane productSearch;

    public void search(ActionEvent event) {
    }

    public void cancel(ActionEvent event) {
        closeScene(productSearch);
    }
}
