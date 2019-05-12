package controllers;

import db.CustomerDBOperation;
import db.OrderDBOperation;
import db.ProductDBOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static commonFunctions.CustomerCommonFunctions.showCustomersComboBox;
import static commonFunctions.GeneralCommonFunctions.closeScene;
import static commonFunctions.ProductCommonFunction.showProductsInComboBox;

public class ManageOrderController implements Initializable {
    @FXML private ComboBox customerComboBox;
    @FXML private ComboBox productComboBox;
    @FXML private TextField quantityTxtField;
    @FXML private TextField orderDateTxtField;
    @FXML private AnchorPane orderManage;
    private  String customerSelected;
    private String productSelected;

    public void insertOrder(ActionEvent event) throws SQLException, ClassNotFoundException {
        System.out.println(CustomerDBOperation.searchCustomrtByName(customerSelected));
        System.out.println(ProductDBOperation.searchProductByName(productSelected));
        OrderDBOperation.addOrder(customerSelected,productSelected,quantityTxtField,System.currentTimeMillis());
    }

    public void showOrders(ActionEvent event) {
    }

    public void cancel(ActionEvent event) {
        closeScene(orderManage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showCustomersComboBox(customerComboBox);
            showProductsInComboBox(productComboBox);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
       }
    }

    @FXML
    public void customerSelected(ActionEvent event) {
        customerSelected=customerComboBox.getValue().toString();
    }

    @FXML
    public void productSelected(ActionEvent event) {
        productSelected=productComboBox.getValue().toString();
    }

    public void dateChoosed(ActionEvent event) {
    }
}
