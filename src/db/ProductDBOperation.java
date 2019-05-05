package db;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static commonFunctions.ProductCommonFunction.showWarnningDialog;
import static commonFunctions.ProductCommonFunction.wrongInput;

public class ProductDBOperation {
    private static DbConnection dbConnection;
    private static Statement statement;
    private static String query;
    private static ResultSet resultSet;
    private static String gender ;


    public static void addProduct(TextField nameTxt,String category, TextField priceTxt, TextField quantityTxt,
                                  TextArea descriptionTxt)throws SQLException,ClassNotFoundException{
        if (!check(nameTxt,category,priceTxt,quantityTxt,descriptionTxt)){
            showWarnningDialog();
            return;
        }
        String name=nameTxt.getText();
        Float price;
        int quantity;
        try {
            price = Float.parseFloat(priceTxt.getText());
            quantity = Integer.parseInt(quantityTxt.getText());
        }catch (NumberFormatException ex){
            wrongInput();
            return;
        }
        String description = descriptionTxt.getText();
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        query="INSERT INTO product(name,category,quantity,price,description)" +
                " VALUES ('"+name+"','"+category+"','"+price+"','"+quantity+"','"+description+"')";
        statement.execute(query);

    }


    public static void deleteProduct(){


    }


    private static boolean check(TextField nameTxt,String category, TextField priceTxt, TextField quantityTxt,
                                 TextArea descriptionTxt){
        if (nameTxt.getText().isEmpty()||category.isEmpty()||priceTxt.getText().isEmpty()||
                quantityTxt.getText().isEmpty()||descriptionTxt.getText().isEmpty()){
            return false;
        };
        return true;
    }




}
