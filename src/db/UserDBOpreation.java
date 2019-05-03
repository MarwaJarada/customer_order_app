package db;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDBOpreation {
    private static DbConnection dbConnection;
    private static Statement statement;
    private static String query;
    private static ResultSet resultSet;

    public static boolean verifyUser(TextField userNameTxt, PasswordField passwordField) throws SQLException, ClassNotFoundException {
        String userName =userNameTxt.getText();
        String password =passwordField.getText();
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        query="SELECT * FROM user WHERE name='"+userName+"'AND password='"+password+"'";
        resultSet=statement.executeQuery(query);
        if (resultSet.next())
            return true;
        else return false;
    }

    
}
