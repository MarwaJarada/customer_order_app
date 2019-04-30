package controllers;

import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marwa N. Jarada
 * @since 4/30/2019
 */

public class AddCustomerController extends Component{
    @FXML private TextField idTxtField;
    @FXML private TextField fnameTxtField;
    @FXML private TextField lnameTxtField;
    @FXML private TextField mobileTxtField;
    @FXML private TextField emailTxtField;
    @FXML private TextField addressTxtField;
    @FXML private RadioButton maleRBtn;
    @FXML private RadioButton fmaleRBtn;


    public void clearBtn(ActionEvent event) {
    }

    public void addCustomerBtn(ActionEvent event) {
    }

    public void cancelBtn(ActionEvent event) {
    }
}
