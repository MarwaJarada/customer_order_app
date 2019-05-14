package controllers;

import commonFunctions.CustomerCommonFunctions;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static commonFunctions.CustomerCommonFunctions.insertDone;
import static commonFunctions.GeneralCommonFunctions.closeScene;

/**
 * @author Marwa N. Jarada
 * @since 4/30/2019
 */

public class AddCustomerController implements Initializable{
    @FXML private AnchorPane addCustomer;
    @FXML private TextField idTxtField;
    @FXML private TextField fnameTxtField;
    @FXML private TextField lnameTxtField;
    @FXML private TextField mobileTxtField;
    @FXML private TextField emailTxtField;
    @FXML private TextField addressTxtField;
    @FXML private RadioButton maleRBtn;
    @FXML private RadioButton femaleRBtn;


    public void clearBtn(ActionEvent event) {
        CustomerCommonFunctions.clearCustomerFields(idTxtField,fnameTxtField,lnameTxtField,mobileTxtField,
                emailTxtField,addressTxtField,maleRBtn,femaleRBtn);


    }

    public void addCustomerBtn(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        db.CustomerDBOperation.addCustomer(idTxtField,fnameTxtField,lnameTxtField,mobileTxtField,
                emailTxtField,addressTxtField,femaleRBtn,maleRBtn);
    }

    public void cancelBtn(ActionEvent event) {
        closeScene(addCustomer);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mobileTxtField.setText("059");

    }
}
