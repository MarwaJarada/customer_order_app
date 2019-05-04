package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.SQLException;
import static commonFunctions.GeneralCommonFunctions.closeScene;
import static commonFunctions.GeneralCommonFunctions.openNewScene;
import static db.UserDBOpreation.verifyUser;

public class LoginScreenController {
    @FXML private AnchorPane screenLogin;
    @FXML private Label errorLogin;
    @FXML private TextField loginNameTxtField;
    @FXML private PasswordField passwordTxtField;


    public void ok(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        try {
            if (verifyUser(loginNameTxtField,passwordTxtField)) openNewScene(this.getClass(),screenLogin,"../view/menu_main.fxml","Main Menu") ;
            else {
                errorLogin.setText("Error Name or Password");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancel(ActionEvent event) {
        closeScene(screenLogin);
    }
}
