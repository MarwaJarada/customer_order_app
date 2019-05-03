package controllers;

import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;
import java.sql.Statement;

public class LoginScreenController {
    @FXML private TextField loginNameTxtField;
    @FXML private  TextField passwordTxtField;


    public void ok(ActionEvent event) {

    }

    public void cancel(ActionEvent event) {
    }
}
