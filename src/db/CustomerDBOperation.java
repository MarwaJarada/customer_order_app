package db;

import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDBOperation {
    private static DbConnection dbConnection;
    private static Statement statement;
    private static String query;
    private static ResultSet resultSet;

    public static void addCustomer(TextField idtxt, TextField fnametxt, TextField lnametxt, TextField mobiletxt,
                                   TextField emailTxt,TextField addressTxt, String gender)
            throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(idtxt.getText());
        String fname = fnametxt.getText();
        String lname = lnametxt.getText();
        int mobile = Integer.parseInt(mobiletxt.getText());
        String email = emailTxt.getText();
        String address = addressTxt.getText();
        dbConnection = DbConnection.getConnection();
        statement = dbConnection.getStatement();
        query = "INSERT INTO CUSTOMER VALUES('" + id + "','" + fname + "','" + lname + "','" + mobile + "','" + email + "','" +
                address + "','" + gender + "')";
        statement.execute(query);
        System.out.println(statement.getUpdateCount() + "Inserted");


    }

    public static void deleteCustomer(){
        /**
         * @//TODO: 5/1/2019 implenet query to delete customer
         */
    }

    public static void manageCustomer(){
        /**
         * @// TODO: 5/1/2019 implement qury to manage customer
         */
    }

    /**
     *  This method serach by id , and then return the data to show it in the user interface  for updating
     */

    public static ArrayList<String> searchCustomer(TextField previousId) throws SQLException, ClassNotFoundException {
        Long id=Long.parseLong(previousId.getText());
        dbConnection = DbConnection.getConnection();
        statement = dbConnection.getStatement();
        query = "SELECT * FROM CUSTOMER WHERE id ='"+id+"'";
        resultSet = statement.executeQuery(query);
        resultSet.next();
        ArrayList<String> previousCustomerDetails =
                new ArrayList<String>();
        previousCustomerDetails.add(String.valueOf(resultSet.getLong("id")));
        previousCustomerDetails.add(resultSet.getString("fname"));
        previousCustomerDetails.add(resultSet.getString("lname"));
        previousCustomerDetails.add(String.valueOf(resultSet.getLong("mobile")));
        previousCustomerDetails.add(resultSet.getString("email"));
        previousCustomerDetails.add(resultSet.getString("address"));
        previousCustomerDetails.add(resultSet.getString("gender"));
        return previousCustomerDetails;


    }

    public static void updateCustomer(TextField idtxt, TextField fnametxt, TextField lnametxt, TextField mobiletxt,
                                      TextField emailTxt,TextField addressTxt, String gender)
            throws SQLException, ClassNotFoundException {
        int id=Integer.parseInt(idtxt.getText());
        String fname=fnametxt.getText();
        String lname=lnametxt.getText();
        int mobile=Integer.parseInt(mobiletxt.getText());
        String email=emailTxt.getText();
        String address = addressTxt.getText();
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        query="UPDATE customer SET id='"+id+"',fname='"+fname+"',lname='"+lname+"',mobile='"+mobile+"'," +
                "email='"+email+"',address='"+ address+"',gender='"+gender+"' WHERE id ='"+id+"'";
        statement.execute(query);

    }


}
