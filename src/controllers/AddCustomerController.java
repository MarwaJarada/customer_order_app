package controllers;

import commonFunctions.CustomerCommonFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.SQLException;

/**
 * @author Marwa N. Jarada
 * @since 4/30/2019
 */

public class AddCustomerController extends Component{
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

    public void addCustomerBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        db.CustomerDBOperation.addCustomer(idTxtField,fnameTxtField,lnameTxtField,mobileTxtField,
                emailTxtField,addressTxtField,femaleRBtn,maleRBtn);
    }

    public void cancelBtn(ActionEvent event) {
        Stage stage=(Stage)addCustomer.getScene().getWindow();
        stage.close();
    }
}
