package db;

import entity.Customer;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import log.Log;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import static commonFunctions.CustomerCommonFunctions.*;
import static log.Log.log;
import static log.Log.logDelete;

public class CustomerDBOperation {
    private static DbConnection dbConnection;
    private static Statement statement;
    private static String query;
    private static ResultSet resultSet;
    private static String gender ;

    public static void addCustomer(TextField idtxt, TextField fnametxt, TextField lnametxt, TextField mobiletxt,
                                   TextField emailTxt,TextField addressTxt, RadioButton female,RadioButton male)
            throws SQLException, ClassNotFoundException, IOException {
        if (!check(idtxt,fnametxt,lnametxt,mobiletxt,emailTxt,addressTxt,female,male)){
            showWarnningDialog();
            return;
        }

        int id = Integer.parseInt(idtxt.getText());
        String fname = fnametxt.getText();
        String lname = lnametxt.getText();
        int mobile;
        try {
            mobile = Integer.parseInt(mobiletxt.getText());
        }catch (NumberFormatException ex){
            wrongInput();
            return;
        }
        String email = emailTxt.getText();
        String address = addressTxt.getText();
        dbConnection = DbConnection.getConnection();
        statement = dbConnection.getStatement();
        query = "INSERT INTO CUSTOMER VALUES('" + id + "','" + fname + "','" + lname + "','" + mobile + "','" + email + "','" +
                address + "','" + gender + "')";
        try {
            if(!statement.execute(query)){
                log("customer",new Customer(id,fname,lname,mobile,email,address,gender));
                insertDone();}
        }catch (SQLException ex) {
            wrongId();
        }


    }

    public static void deleteCustomer(long id) throws SQLException, ClassNotFoundException {
            query="DELETE FROM customer WHERE id='"+id+"'";
            dbConnection=DbConnection.getConnection();
            statement=dbConnection.getStatement();
            try {
                statement.execute(query);
                logDelete("customer",new Customer(id));
            }catch (SQLException ex){
                invalidCustomerDelete();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }


    public static ArrayList<String> searchCustomer(TextField previousId) throws SQLException, ClassNotFoundException {
        Long id=Long.parseLong(previousId.getText());
        dbConnection = DbConnection.getConnection();
        statement = dbConnection.getStatement();
        query = "SELECT * FROM CUSTOMER WHERE id ='"+id+"'";
        try {
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
        }catch (SQLException ex){
            idNotFound();
            return null;
        }



    }

    public static void updateCustomer(TextField idtxt, TextField fnametxt, TextField lnametxt, TextField mobiletxt,
                                      TextField emailTxt,TextField addressTxt, RadioButton femaleBtn,RadioButton maleBtn)
            throws SQLException, ClassNotFoundException {
        if (!check(idtxt,fnametxt,lnametxt,mobiletxt,emailTxt,addressTxt,femaleBtn,maleBtn)){
            showWarnningDialog();
            return;
        }
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


    public static ObservableList<Customer> showCustomer() throws SQLException,ClassNotFoundException{
        ObservableList<Customer> customers= FXCollections.observableArrayList();
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        query="SELECT * FROM customer";
        resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            Customer customer=new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setFname(resultSet.getString("fname"));
            customer.setLname(resultSet.getString("lname"));
            customer.setMobile(resultSet.getInt("mobile"));
            customer.setEmail(resultSet.getString("email"));
            customer.setAddress(resultSet.getString("address"));
            customer.setGender(resultSet.getString("gender"));
            customers.add(customer);
        }
        return customers;
    }

    private static boolean check(TextField idtxt, TextField fnametxt, TextField lnametxt, TextField mobiletxt,
                             TextField emailTxt, TextField addressTxt, RadioButton femlaeBtn,RadioButton maleBtn){
        if (femlaeBtn.isSelected()) gender="female";
        else if (maleBtn.isSelected())gender="male";
        if (idtxt.getText().isEmpty()||fnametxt.getText().isEmpty()||lnametxt.getText().isEmpty()||
                mobiletxt.getText().isEmpty()||emailTxt.getText().isEmpty()||
                addressTxt.getText().isEmpty()||(!femlaeBtn.isSelected() && !maleBtn.isSelected())){
            return false;


        };
        return true;
    }

    public static Customer searchCustomrtById(long id) throws SQLException, ClassNotFoundException {
        Optional<Customer> result=showCustomer().stream().filter(cutomer->cutomer.getId()==id).findFirst();
        return result.get();
    }



}
