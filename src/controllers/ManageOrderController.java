package controllers;

import db.CustomerDBOperation;
import db.OrderDBOperation;
import db.ProductDBOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    @FXML private AnchorPane orderManage;
    @FXML private DatePicker datePicker;
    private  String customerSelected;
    private String productSelected;
    private String dateSelected;
    @FXML
    public void insertOrder(ActionEvent event){

        try {
            OrderDBOperation.addOrder(customerSelected,productSelected,dateSelected,quantityTxtField);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void showOrders(ActionEvent event) {
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
    @FXML
    public void dateChoosed(ActionEvent event) {
        dateSelected=datePicker.getValue().toString();
    }
}
