package controllers;

import commonFunctions.ProductCommonFunction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
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
    @FXML private TableView updateProductTable;
    @FXML private TableColumn nameCol;
    @FXML private TableColumn categoryCol;
    @FXML private TableColumn quantityCol;
    @FXML private TableColumn priceCol;
    @FXML private TableColumn descriptionCol;

    public void cancel(ActionEvent event) {
        closeScene(productUpdate);
    }

    public void confirm(ActionEvent event) {
    }

    public void updateProduct(ActionEvent event) throws SQLException, ClassNotFoundException {
        ProductCommonFunction.
                refreshProducts(updateProductTable,nameCol,categoryCol,quantityCol,priceCol,descriptionCol);
    }

    public void refreshProducts(ActionEvent event) {
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
}
