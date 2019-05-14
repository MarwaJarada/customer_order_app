package db;
import entity.Customer;
import entity.Order;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import static commonFunctions.ProductCommonFunction.*;
import static db.CustomerDBOperation.searchCustomrtById;
import static log.Log.log;

public class ProductDBOperation {
    private static DbConnection dbConnection;
    private static Statement statement;
    private static String query;
    private static ResultSet resultSet;


    public static void addProduct(TextField nameTxt, String category, TextField priceTxt, TextField quantityTxt,
                                  TextArea descriptionTxt) throws SQLException, ClassNotFoundException, IOException {
        if (!check(nameTxt,category,priceTxt,quantityTxt,descriptionTxt)){
            showWarnningDialog();
            return;
        }
        String name=nameTxt.getText();
        Float price;
        int quantity;
        try {
            price = Float.parseFloat(priceTxt.getText());
            quantity = Integer.parseInt(quantityTxt.getText());
        }catch (NumberFormatException ex){
            wrongInput();
            return;
        }
        String description = descriptionTxt.getText();
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        query="INSERT INTO product(name,category,quantity,price,description)" +
                " VALUES ('"+name+"','"+category+"','"+price+"','"+quantity+"','"+description+"')";
        statement.execute(query);
        log("product",new Product(name,category,quantity,price,description));
        insertDone();

    }


    public static void deleteProduct(long id) throws SQLException,ClassNotFoundException{
        query="DELETE FROM product WHERE id='"+id+"'";
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        try {
            statement.execute(query);
        }catch (SQLException ex){
            invalidProductDelete();
        }
    }


    public static ObservableList<Product> showProducts() throws SQLException,ClassNotFoundException{
        ObservableList<Product> products= FXCollections.observableArrayList();
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        query="SELECT * FROM product";
        resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            Product product=new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setCategory(resultSet.getString("category"));
            product.setQuantity(resultSet.getInt("quantity"));
            product.setPrice(resultSet.getFloat("price"));
            product.setDescription(resultSet.getString("description"));
            products.add(product);
        }
        return products;
    }

    public static void updateProduct(long id,TextField nameTxt,String category, TextField priceTxt, TextField quantityTxt,
                                     TextArea descriptionTxt) throws SQLException,ClassNotFoundException {
        if (!check(nameTxt,category,priceTxt,quantityTxt,descriptionTxt)){
            showWarnningDialog();
            return;
        }else {
            int price; double quantity;
            String name = nameTxt.getText();
            try {
                price = Integer.parseInt(priceTxt.getText());
                quantity = Double.parseDouble(quantityTxt.getText());

            }catch (NumberFormatException ex){
                wrongInput();
                return;
            }
            String description = descriptionTxt.getText();
            query = "UPDATE product SET name='" + name + "', category ='" + category + "', price='" + price +
                    "',quantity='" + quantity +"',description='" + description + "' WHERE id='" + id + "'";
            dbConnection = DbConnection.getConnection();
            statement = dbConnection.getStatement();
            statement.execute(query);
            updateDone();
        }}


        public static  ObservableList<Product> showCategoryProduct(String category) throws ClassNotFoundException ,SQLException{
        if (category.isEmpty()) {selectCategory();return null;}
        ObservableList<Product> products=FXCollections.observableArrayList();
        query="SELECT * FROM product WHERE category='"+category+"'";
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            Product product=new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setCategory(resultSet.getString("category"));
            product.setQuantity(resultSet.getInt("quantity"));
            product.setPrice(resultSet.getFloat("price"));
            product.setDescription(resultSet.getString("description"));
            products.add(product);

        }return products;

        }

    private static boolean check(TextField nameTxt,String category, TextField priceTxt, TextField quantityTxt,
                                 TextArea descriptionTxt){
        if(nameTxt.getText().isEmpty()||category.isEmpty()||priceTxt.getText().isEmpty()||
                quantityTxt.getText().isEmpty()||descriptionTxt.getText().isEmpty()){
            return false;
        };
        return true;
    }

    public static Product searchProductById(long id) throws SQLException, ClassNotFoundException {
        Optional<Product> result=showProducts().stream().filter(product->product.getId()==id).findFirst();
        return result.get();
    }

    public static double searchPriceProductById(int id) throws SQLException, ClassNotFoundException {
        Optional<Product> result=showProducts().stream().filter(product->product.getId()==id).findFirst();
        return result.get().getPrice();
    }

    public static double productPrice(long id) throws SQLException {
        query="SELECT price FROM product WHERE id='"+id+"'";
        dbConnection=DbConnection.getConnection();
        try {
            statement=dbConnection.getStatement();
            resultSet=statement.executeQuery(query);
            resultSet.next();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return resultSet.getDouble("price");
        }

   }


    public static int productQuantity(long id) throws SQLException {
        query="SELECT quantity FROM product WHERE id='"+id+"'";
        dbConnection=DbConnection.getConnection();
        try {
            statement=dbConnection.getStatement();
            resultSet=statement.executeQuery(query);
            resultSet.next();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return resultSet.getInt("quantity");
        }

    }



    public static ObservableList<Order> showOrders() throws SQLException,ClassNotFoundException{
        ObservableList<Order> orders= FXCollections.observableArrayList();
        query="SELECT * FROM customerorder";
        dbConnection=DbConnection.getConnection();
        statement=dbConnection.getStatement();
        resultSet=statement.executeQuery(query);
        int customerId;int productId;int quantity;double price;double totalPrice;Customer customer;Product product;
        while (resultSet.next()){
            customerId=resultSet.getInt("customer_id");
            productId=resultSet.getInt("product_id");
            quantity=resultSet.getInt("quantity");
            totalPrice=resultSet.getDouble("total_price");
            customer=new Customer(customerId);
            product=new Product(productId);
            orders.add(new Order(customer,product,quantity,totalPrice/quantity,totalPrice));
        }
        orders.stream().forEach(order -> {
            try {
                order.setCustomer(searchCustomrtById(order.getCustomer().getId()));
                order.setProduct(searchProductById(order.getProduct().getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        return orders;
    }

}
