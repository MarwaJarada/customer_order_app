package controllers;

import commonFunctions.CustomerCommonFunctions;
import commonFunctions.ProductCommonFunction;
import db.CustomerDBOperation;
import db.ProductDBOperation;
import entity.Customer;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static commonFunctions.CustomerCommonFunctions.deleteConfirmation;
import static commonFunctions.GeneralCommonFunctions.closeScene;
import static db.CustomerDBOperation.showCustomer;
import static db.CustomerDBOperation.updateCustomer;

public class DeleteCustomerController implements Initializable{
    @FXML private AnchorPane customerDelete;
    @FXML private TableView deleteCustomerTable;
    @FXML private TableColumn idCol;
    @FXML private TableColumn fnameCol;
    @FXML private TableColumn lnameCol;
    @FXML private TableColumn mobileCol;
    @FXML private TableColumn emailCol;
    @FXML private TableColumn addressCol;
    @FXML private TableColumn genderCol;


    public void cancel(ActionEvent event) {
        closeScene(customerDelete);
    }

    public void deleteCustomer(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Customer> customers = deleteCustomerTable.getSelectionModel().getSelectedItems();
        if (customers.get(0)!=null){
            deleteConfirmation(customers.get(0).getId());
        CustomerCommonFunctions.
                refreshCustomers(deleteCustomerTable,idCol,fnameCol,lnameCol,mobileCol,emailCol,addressCol,genderCol);}
        else CustomerCommonFunctions.selectCustomer();

    }

    public void refreshCustomers(ActionEvent event) throws SQLException, ClassNotFoundException {
        CustomerCommonFunctions.
                refreshCustomers(deleteCustomerTable,idCol,fnameCol,lnameCol,mobileCol,emailCol,addressCol,genderCol);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            CustomerCommonFunctions.
                    refreshCustomers(deleteCustomerTable,idCol,fnameCol,lnameCol,mobileCol,emailCol,addressCol,genderCol);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}