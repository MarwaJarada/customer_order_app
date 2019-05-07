package controllers;

import commonFunctions.ProductCommonFunction;
import db.ProductDBOperation;
import entity.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.MenuItem;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static commonFunctions.GeneralCommonFunctions.closeScene;

public class UpdateProductController implements Initializable {
    @FXML private AnchorPane productUpdate;
    @FXML private TextField nameTxtField;
    @FXML private TextField priceTxtField;
    @FXML private TextField quantityTxtField;
    @FXML private TextArea descriptionTxtArea;
    @FXML private MenuButton categoryMenuBtn;
    @FXML private TableView<Product> updateProductTable;
    @FXML private TableColumn nameCol;
    @FXML private TableColumn categoryCol;
    @FXML private TableColumn quantityCol;
    @FXML private TableColumn priceCol;
    @FXML private TableColumn descriptionCol;



    public void cancel(ActionEvent event) {
        closeScene(productUpdate);
    }

    public void confirm(ActionEvent event) throws SQLException, ClassNotFoundException {

        ObservableList<Product> product= updateProductTable.getSelectionModel().getSelectedItems();
        ProductDBOperation.updateProduct(product.get(0).getId(),nameTxtField,categoryMenuBtn.getText(),priceTxtField,
                quantityTxtField,descriptionTxtArea);


    }

    public void updateProduct(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (updateProductTable.getSelectionModel().getSelectedItems().get(0)!=null) {
            ObservableList<Product> product= updateProductTable.getSelectionModel().getSelectedItems();
            nameTxtField.setText(product.get(0).getName());
            priceTxtField.setText(String.valueOf(product.get(0).getPrice()));
            quantityTxtField.setText(String.valueOf(product.get(0).getQuantity()));
            categoryMenuBtn.setText(product.get(0).getCategory());
            descriptionTxtArea.setText(product.get(0).getDescription());

        }


    }

    public void refreshProducts(ActionEvent event) throws SQLException, ClassNotFoundException {
        ProductCommonFunction.
                refreshProducts(updateProductTable,nameCol,categoryCol,quantityCol,priceCol,descriptionCol);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ProductCommonFunction.
                    refreshProducts(updateProductTable,nameCol,categoryCol,quantityCol,priceCol,descriptionCol);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void chooseCategory(ActionEvent event) {
        MenuItem selected = (MenuItem)event.getSource();
        String itemSelected=selected.getText();
        categoryMenuBtn.setText(itemSelected);
    }
}
