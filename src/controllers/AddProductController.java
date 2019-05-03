package controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;

import static commonFunctions.GeneralCommonFunctions.closeScene;

public class AddProductController extends Application{
    @FXML private AnchorPane productAdd;
    @FXML private TextField nameTxtView;
    @FXML private TextField priceTxtView;
    @FXML private TextField quantityTxtView;
    @FXML private TextArea descriptionTxtArea;
    @FXML private MenuButton categoryMenuBtn;
    private MenuItem technologyItem;
    private MenuItem helthyItem;
    private MenuItem industryItem;
    private MenuItem kitchenItem;


    public void cancel(ActionEvent event) {
        closeScene(productAdd);
    }

    public void addOrder(ActionEvent event) {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("view\\product_add.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        technologyItem=new MenuItem("technology");
        helthyItem =new MenuItem("healthy");
        industryItem=new MenuItem("industry");
        kitchenItem=new MenuItem("kitchen");
        categoryMenuBtn.getItems().add(technologyItem);
        categoryMenuBtn.getItems().add(helthyItem);
        categoryMenuBtn.getItems().add(industryItem);
        categoryMenuBtn.getItems().add(kitchenItem);
        primaryStage.show();


    }
}
