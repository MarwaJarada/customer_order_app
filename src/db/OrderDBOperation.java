package db;

import commonFunctions.ProductCommonFunction;
import entity.Customer;
import entity.Product;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OrderDBOperation {
    private static DbConnection dbConnection;
    private static Statement statement;
    private static String query;
    private static ResultSet resultSet;


    public static void addOrder(Customer customer, Product product, String date, TextField quantityTxt)
            throws SQLException, ClassNotFoundException {
        if (!check(customer,product,date,quantityTxt)){
            showWarnningDialog();
            return;
        }
       int quantity=Integer.parseInt(quantityTxt.getText());
       if (checkQuantity(product.getId(),quantity)){
        dbConnection = DbConnection.getConnection();
        statement = dbConnection.getStatement();
        query = "INSERT INTO customerorder VALUES('" + customer.getId()+
                "','" + product.getId()+ "','" + date + "','"+quantity+ "','"+ProductDBOperation.
                productPrice(product.getId())*quantity+"')";
        statement.execute(query);
        subtractQuantity(product.getId(),quantity);
        ProductCommonFunction.orderInserted();

       }

    }

    private static boolean check(Customer customer,Product product, String date, TextField quantityTxt){
        if(customer==null||product==null||date.isEmpty()||
                quantityTxt.getText().isEmpty()){
            return false;
        };
        return true;
    }



    public static boolean checkQuantity(long id,int orderQuantity)
            throws SQLException, ClassNotFoundException {
        dbConnection = DbConnection.getConnection();
        statement = dbConnection.getStatement();
        query = "SELECT quantity FROM product WHERE id='"+id+"'";
        resultSet=statement.executeQuery(query);
        resultSet.next();
        int productQuantity= resultSet.getInt("quantity");
        if (productQuantity==0) ProductCommonFunction.outOfOrder();
        if (orderQuantity!=0) {
            if (productQuantity >= orderQuantity) return true;
            else{
                ProductCommonFunction.hugeQuantity();
                return false;
            }
        }else {
            ProductCommonFunction.selectQuantity();
            return false;
        }
    }

    public  static void subtractQuantity(long id,int quantity){

        try {
            int newQuantity=ProductDBOperation.productQuantity(id)-quantity;
            query="UPDATE product SET quantity='"+newQuantity+"' WHERE id='"+id+"'";
            dbConnection=DbConnection.getConnection();
            try {
                statement=dbConnection.getStatement();
                statement.execute(query);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showWarnningDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Be carefull");
        alert.setHeaderText("Fill all the Fields , Please ...");
        alert.setContentText("You must enter all information about order to Add");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }


}
