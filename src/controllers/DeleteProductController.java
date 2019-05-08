package controllers;

import commonFunctions.ProductCommonFunction;
import db.ProductDBOperation;
import entity.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static commonFunctions.GeneralCommonFunctions.closeScene;

public class DeleteProductController implements Initializable {
    @FXML private TableView deleteProductTable;
    @FXML private AnchorPane productDelete;
    @FXML private TableColumn nameCol;
    @FXML private TableColumn categorieCol;
    @FXML private TableColumn quantityCol;
    @FXML private TableColumn priceCol;
    @FXML private TableColumn descriptionCol;

    public void cancel(ActionEvent event) {
        closeScene(productDelete);
    }

    public void deleteProduct(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Product> products = deleteProductTable.getSelectionModel().getSelectedItems();
        try {
            if (products.get(0)!=null)
            ProductDBOperation.deleteProduct(products.get(0).getId());
            else ProductCommonFunction.selectProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void refreshProducts(ActionEvent event) throws SQLException, ClassNotFoundException {
        ProductCommonFunction.
                refreshProducts(deleteProductTable,nameCol,categorieCol,quantityCol,priceCol,descriptionCol);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ProductCommonFunction.refreshProducts(deleteProductTable,nameCol,categorieCol,quantityCol,priceCol,
                    descriptionCol);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
