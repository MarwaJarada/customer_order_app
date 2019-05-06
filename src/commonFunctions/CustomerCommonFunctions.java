package commonFunctions;

import entity.Customer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

import static db.CustomerDBOperation.showCustomer;

public class CustomerCommonFunctions {


    public static void clearCustomerFields(TextField idTxtField,TextField fnameTxtField,TextField lnameTxtField,
                                           TextField mobileTxtField,TextField emailTxtField,TextField addressTxtField,
                                           RadioButton maleRBtn,RadioButton femaleRBtn){
        idTxtField.setText(null);
        fnameTxtField.setText(null);
        lnameTxtField.setText(null);
        mobileTxtField.setText(null);
        emailTxtField.setText(null);
        addressTxtField.setText(null);
        maleRBtn.setSelected(false);
        femaleRBtn.setSelected(false);
    }

    public static void showWarnningDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Be carefull");
        alert.setHeaderText("Fill all the Fields , Please ...");
        alert.setContentText("You must enter all information about customer to Add/update his information successfully");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void refreshCustomers(TableView tableView,TableColumn idCol, TableColumn fnameCol, TableColumn lnameCol,
                                        TableColumn mobileCol, TableColumn emailCol, TableColumn addressCol,
                                        TableColumn genderCol) throws SQLException, ClassNotFoundException {
        ObservableList<Customer> customers=showCustomer();
        idCol.setCellValueFactory(new PropertyValueFactory<String,Customer>("id"));
        fnameCol.setCellValueFactory(new PropertyValueFactory<String,Customer>("fname"));
        lnameCol.setCellValueFactory(new PropertyValueFactory<String,Customer>("lname"));
        mobileCol.setCellValueFactory(new PropertyValueFactory<String,Customer>("mobile"));
        emailCol.setCellValueFactory(new PropertyValueFactory<String,Customer>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<String,Customer>("address"));
        genderCol.setCellValueFactory(new PropertyValueFactory<String,Customer>("gender"));
        tableView.setItems(customers);
    }
}
