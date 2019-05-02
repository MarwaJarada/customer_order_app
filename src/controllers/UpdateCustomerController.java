package controllers;

import db.CustomerDBOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateCustomerController {
    @FXML private AnchorPane customerUpdate;
    @FXML private TextField customerIdTxtField;
    @FXML private TextField idTxtField;
    @FXML private TextField fnameTxtField;
    @FXML private TextField lnameTxtField;
    @FXML private TextField mobileTxtField;
    @FXML private TextField emailTxtField;
    @FXML private TextField addressTxtField;
    @FXML private RadioButton maleRBtn;
    @FXML private RadioButton femaleRBtn;
    private ArrayList<String> prevoiusCustomrtDetails;

    public void cancel(ActionEvent event) {
        Stage stage=(Stage)customerUpdate.getScene().getWindow();
        stage.close();
    }

    public void updateCustomer(ActionEvent event) throws SQLException, ClassNotFoundException {
        String gender = null;
        CustomerDBOperation.updateCustomer
                (idTxtField,fnameTxtField,lnameTxtField,mobileTxtField,emailTxtField,addressTxtField,femaleRBtn,maleRBtn);
    }

    public void serachCustomer(ActionEvent event) throws SQLException, ClassNotFoundException {
        prevoiusCustomrtDetails=CustomerDBOperation.searchCustomer(customerIdTxtField);
        idTxtField.setText(prevoiusCustomrtDetails.get(0));
        idTxtField.setEditable(false);
        fnameTxtField.setText(prevoiusCustomrtDetails.get(1));
        lnameTxtField.setText(prevoiusCustomrtDetails.get(2));
        mobileTxtField.setText(prevoiusCustomrtDetails.get(3));
        emailTxtField.setText(prevoiusCustomrtDetails.get(4));
        addressTxtField.setText(prevoiusCustomrtDetails.get(5));
        String gender = prevoiusCustomrtDetails.get(6);
        if (gender.equals("female")) femaleRBtn.setSelected(true);
        else femaleRBtn.setSelected(true);
    }
}
