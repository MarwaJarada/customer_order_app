package db;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


    public static void deleteProduct(long id) throws SQLException,ClassNotFoundException{
        query="DELETE FROM product WHERE id='"+id+"'";
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        statement.execute(query);
    }


    public static ObservableList<Product> showProducts() throws SQLException,ClassNotFoundException{
        ObservableList<Product> products= FXCollections.observableArrayList();
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        query="SELECT * FROM product";
        resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            Product product=new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setCategory(resultSet.getString("category"));
            product.setQuantity(resultSet.getInt("quantity"));
            product.setPrice(resultSet.getFloat("price"));
            product.setDescription(resultSet.getString("description"));
            products.add(product);
        }
        return products;
    }

    public static void updateProduct(long id,TextField nameTxt,String category, TextField priceTxt, TextField quantityTxt,
                                     TextArea descriptionTxt) throws SQLException,ClassNotFoundException{
        String name=nameTxt.getText();
        String price=priceTxt.getText();
        String quantity=quantityTxt.getText();
        String description=descriptionTxt.getText();
        query="UPDATE product SET name='"+name+"', category ='"+category+"', price='"+price+"',quantity='"+quantity+
                "',description='"+description+"' WHERE id='"+id+"'";
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        statement.execute(query);
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
