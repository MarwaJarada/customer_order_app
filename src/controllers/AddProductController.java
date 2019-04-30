package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import java.awt.*;

public class AddProductController extends Component{
    @FXML private TextField nameTxtView;
    @FXML private TextField priceTxtView;
    @FXML private TextField quantityTxtView;
    @FXML private TextArea descriptionTxtArea;
    @FXML private MenuButton categoryMenuBtn;

    public void cancel(ActionEvent event) {
    }

    public void addOrder(ActionEvent event) {
    }
}
