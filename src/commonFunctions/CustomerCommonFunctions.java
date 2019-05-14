package commonFunctions;

import entity.Customer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

import static db.CustomerDBOperation.deleteCustomer;
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

    public static void selectCustomer(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Be carefull");
        alert.setHeaderText("Select Customer ..");
        alert.setContentText("You must select Customer from table ! ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void showCustomersComboBox(ComboBox<Customer> comboBox) throws SQLException, ClassNotFoundException {
        ObservableList<Customer> customers=showCustomer();
        MenuItem menuItem=new MenuItem();
        customers.stream().forEach(customer->comboBox.getItems().add(customer));
    }


    public static void insertDone(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Done");
        alert.setHeaderText("Inserting done successfully ..");
        alert.setContentText("One customer Inserted  ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }


    public static void deleteConfirmation(long id){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"dd",ButtonType.YES,ButtonType.NO);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure ? ..");
        alert.setContentText("If you deleted this customer you will lose his data  ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs==ButtonType.YES){
                try {
                    deleteCustomer(id);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else if (rs==ButtonType.NO){
                alert.close();
            }
        });
    }

    public static void wrongId(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Id dublication");
        alert.setHeaderText("Add a unique ID  ..");
        alert.setContentText("The id you entered are used ..  ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.APPLY) {
                System.out.println("Pressed OK.");}
        });
    }

    public static void wrongInput(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Wrong Input");
        alert.setHeaderText("Mobile must't be number  ..");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.APPLY) {
                System.out.println("Pressed OK.");}
        });
    }

    public static void invalidCustomerDelete(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Delete");
        alert.setHeaderText("This customer has orders  ..");
        alert.setContentText("Delete this customr invalid because he has orders ..  ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.APPLY) {
                System.out.println("Pressed OK.");}
        });
    }

    public static void idNotFound(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Id");
        alert.setHeaderText("This ID Does'nt exist  ..");
        alert.setContentText("Id entered are not for a spesific customer ..  ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.APPLY) {
                System.out.println("Pressed OK.");}
        });
    }

}
