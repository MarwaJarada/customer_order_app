package controllers;

import db.CustomerDBOperation;
import db.OrderDBOperation;
import db.ProductDBOperation;
import entity.Customer;
import entity.Order;
import entity.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static commonFunctions.CustomerCommonFunctions.showCustomersComboBox;
import static commonFunctions.GeneralCommonFunctions.closeScene;
import static commonFunctions.ProductCommonFunction.refreshOrders;
import static commonFunctions.ProductCommonFunction.showProductsInComboBox;

public class ManageOrderController implements Initializable {
    @FXML private ComboBox customerComboBox;
    @FXML private ComboBox productComboBox;
    @FXML private TextField quantityTxtField;
    @FXML private AnchorPane orderManage;
    @FXML private DatePicker datePicker;
    @FXML private TableView<Order> tableOrder;
    @FXML private TableColumn customerCol;
    @FXML private TableColumn productCol;
    @FXML private TableColumn quantityCol;
    @FXML private TableColumn priceCol;
    @FXML private TableColumn totalPriceCol;
    private  Customer customerSelected=null;
    private Product productSelected=null;
    private String dateSelected="";
    @FXML
    public void insertOrder(ActionEvent event){

        try {
            OrderDBOperation.addOrder(customerSelected,productSelected,dateSelected,quantityTxtField);
        } catch (SQLException e) {
           e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void showOrders(ActionEvent event) throws SQLException, ClassNotFoundException {
        refreshOrders(tableOrder,customerCol,productCol,quantityCol,priceCol,totalPriceCol);
    }
    @FXML
    public void cancel(ActionEvent event) {
        closeScene(orderManage);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showCustomersComboBox(customerComboBox);
            showProductsInComboBox(productComboBox);
            datePicker.setEditable(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
       }
    }
    @FXML
    public void customerSelected(ActionEvent event) {
        customerSelected=(Customer)customerComboBox.getValue();
    }
    @FXML
    public void productSelected(ActionEvent event) {
        productSelected=(Product) productComboBox.getValue();
    }
    @FXML
    public void dateChoosed(ActionEvent event) {
        dateSelected=datePicker.getValue().toString();
    }
}
