package db;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import static commonFunctions.CustomerCommonFunctions.showWarnningDialog;

public class OrderDBOperation {
    private static DbConnection dbConnection;
    private static Statement statement;
    private static String query;
    private static ResultSet resultSet;


    public static void addOrder(String customer, String product,String date, TextField quantityTxt)
            throws SQLException, ClassNotFoundException {
       String quantity=quantityTxt.getText();
        dbConnection = DbConnection.getConnection();
        statement = dbConnection.getStatement();
        query = "INSERT INTO customerorder(customer_id,product_id,order_date,quantity) VALUES('" + CustomerDBOperation.searchCustomrtByName(customer)+
                "','" + ProductDBOperation.searchProductByName(product) + "','" + date + "','"+4+ "')";
        statement.execute(query);


    }



}
