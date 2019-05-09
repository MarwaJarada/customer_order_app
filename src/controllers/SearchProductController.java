package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

import static commonFunctions.GeneralCommonFunctions.closeScene;
import static commonFunctions.ProductCommonFunction.refreshCategoryProducts;

public class SearchProductController {
    @FXML private MenuButton categorymenuBtn;
    @FXML private TableView searchTable;
    @FXML private AnchorPane productSearch;
    @FXML private TableColumn nameCol;
    @FXML private TableColumn categoryCol;
    @FXML private TableColumn quantityCol;
    @FXML private TableColumn priceCol;
    @FXML private TableColumn descriptionCol;
    private String itemSelected="";

    public void search(ActionEvent event) throws SQLException, ClassNotFoundException {

        refreshCategoryProducts(itemSelected,searchTable,nameCol,categoryCol,quantityCol,priceCol,descriptionCol);
    }

    public void cancel(ActionEvent event) {
        closeScene(productSearch);
    }



    public void chooseCategory(ActionEvent event) {
        MenuItem selected = (MenuItem)event.getSource();
        itemSelected=selected.getText();
        categorymenuBtn.setText(itemSelected);
    }
}
