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


    public static void addOrder(String customer, String product, TextField quantityTxt, long date)
            throws SQLException, ClassNotFoundException {
       String quantity=quantityTxt.getText();
        dbConnection = DbConnection.getConnection();
        statement = dbConnection.getStatement();
        query = "INSERT INTO customerorder VALUES('" + CustomerDBOperation.searchCustomrtByName(customer)+
                "','" + ProductDBOperation.searchProductByName(product) + "','" + date + "','" + quantity + "')";
        statement.execute(query);


    }



}
