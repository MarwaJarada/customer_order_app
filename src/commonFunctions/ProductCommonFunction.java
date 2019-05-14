package commonFunctions;

import entity.Customer;
import entity.Order;
import entity.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.SQLException;

import static db.CustomerDBOperation.showCustomer;
import static db.ProductDBOperation.showCategoryProduct;
import static db.ProductDBOperation.showOrders;
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
        products.stream().forEach(product->comboBox.getItems().add(product));



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

    public static void selectQuantity(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Be carefull");
        alert.setHeaderText("Select Quantity ..");
        alert.setContentText("quantity musn't be zero ! ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void outOfOrder(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Be carefull");
        alert.setHeaderText("No avaliable product ..");
        alert.setContentText("This product not avaliable now ! ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void hugeQuantity(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Be carefull");
        alert.setHeaderText("No avaliable quantity ..");
        alert.setContentText("This product not avaliable with this quantity ! ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void orderInserted(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Done");
        alert.setHeaderText("Inserting done successfully ..");
        alert.setContentText("One Order Inserted  ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public static void refreshOrders(TableView<Order> tableView, TableColumn customerCol,TableColumn productCol,
                                      TableColumn quantityCol,TableColumn priceCol,TableColumn totalPriceCol)

            throws SQLException, ClassNotFoundException {
        ObservableList<Order> orders=showOrders();
        customerCol.setCellValueFactory(new PropertyValueFactory<String, Order>("customer"));
        productCol.setCellValueFactory(new PropertyValueFactory<String,Order>("product"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<Integer,Order>("quantity"));
        priceCol.setCellValueFactory(cellData->new SimpleStringProperty(String.valueOf(orders.get(1).getProduct().getPrice())));
        totalPriceCol.setCellValueFactory(new PropertyValueFactory<Double,Order>("totalPrice"));
        tableView.setItems(orders);

    }


}
