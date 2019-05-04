package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import static commonFunctions.GeneralCommonFunctions.closeScene;

public class DeleteCustomerController {
    @FXML private AnchorPane customerDelete;

    public void cancel(ActionEvent event) {
        closeScene(customerDelete);
    }

    public void deleteCustomer(ActionEvent event) {
    }

    public void refreshCustomers(ActionEvent event) {
    }
}
