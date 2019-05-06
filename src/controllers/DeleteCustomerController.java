package controllers;

import commonFunctions.CustomerCommonFunctions;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

import static commonFunctions.GeneralCommonFunctions.closeScene;
import static db.CustomerDBOperation.showCustomer;
import static db.CustomerDBOperation.updateCustomer;

public class DeleteCustomerController {
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

    public void deleteCustomer(ActionEvent event) {
    }

    public void refreshCustomers(ActionEvent event) throws SQLException, ClassNotFoundException {
        CustomerCommonFunctions.
                refreshCustomers(deleteCustomerTable,idCol,fnameCol,lnameCol,mobileCol,emailCol,addressCol,genderCol);
    }





}
