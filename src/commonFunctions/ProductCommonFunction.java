package commonFunctions;

import entity.Customer;
import entity.Product;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.SQLException;

import static db.CustomerDBOperation.showCustomer;
import static db.ProductDBOperation.showCategoryProduct;
import static db.ProductDBOperation.showProducts;

public class ProductCommonFunction {

    public static void showWarnningDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Be carefull");
        alert.setHeaderText("Fill all the Fields , Please ...");
        alert.setContentText("You must enter all information about Product to Add/update it's information successfully");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void wrongInput(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Be carefull");
        alert.setHeaderText("Enter number of quantity and price ..");
        alert.setContentText("You must enter Number of product quantity and it's price ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void refreshProducts(TableView tableView, TableColumn nameCol, TableColumn categoryCol,
                                       TableColumn quantityCol, TableColumn priceCol, TableColumn descriptionCol)
            throws SQLException, ClassNotFoundException {
        ObservableList<Product> products=showProducts();
        nameCol.setCellValueFactory(new PropertyValueFactory<String, Product>("name"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<String,Product>("category"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<String,Product>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<String,Product>("price"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<String,Product>("description"));
        tableView.setItems(products);
    }


    public static void selectProduct(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Be carefull");
        alert.setHeaderText("Select Product ..");
        alert.setContentText("You must select product from table ! ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void selectCategory(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Be carefull");
        alert.setHeaderText("Select Category ..");
        alert.setContentText("You must select Category to show their items ! ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void refreshCategoryProducts(String category,TableView tableView, TableColumn nameCol, TableColumn categoryCol,
                                       TableColumn quantityCol, TableColumn priceCol, TableColumn descriptionCol)
            throws SQLException, ClassNotFoundException {
        ObservableList<Product> products=showCategoryProduct(category);
        nameCol.setCellValueFactory(new PropertyValueFactory<String, Product>("name"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<String,Product>("category"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<String,Product>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<String,Product>("price"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<String,Product>("description"));
        tableView.setItems(products);
    }

    public static void showProductsInComboBox(ComboBox<Product> comboBox) throws SQLException, ClassNotFoundException {
        ObservableList<Product> products=showProducts();
        products.stream().forEach(product->comboBox.getItems().add(new Product(product.getName())));



    }

    public static void insertDone(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Done");
        alert.setHeaderText("Inserting done successfully ..");
        alert.setContentText("One Product Inserted  ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void updateDone(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Done");
        alert.setHeaderText("Updating done successfully ..");
        alert.setContentText("One Product Updated  ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }


}
