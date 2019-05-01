package db;

import javafx.scene.control.TextField;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDBOperation {
    private static DbConnection dbConnection;
    private static Statement statement;

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
        String query = "INSERT INTO CUSTOMER VALUES('" + id + "','" + fname + "','" + lname + "','" + mobile + "','" + email + "','" +
                address + "','" + gender + "')";
        statement.execute(query);
        System.out.println(statement.getUpdateCount() + "Inserted");


    }

    public static void deleteCustomer(){
        /**
         * @// TODO: 5/1/2019 implenet query to delete customer
         */
    }


}
