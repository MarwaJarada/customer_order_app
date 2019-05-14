package log;


import entity.Customer;
import entity.Order;
import entity.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Timer;

public class Log {
    private static File file;
    private static FileWriter writer;
    private static PrintWriter printWriter;

    public static void log(String objectType,Object object) throws IOException {
        file = new File("src\\log\\Log file.txt");
        writer = new FileWriter(file, true);
        printWriter = new PrintWriter(writer);
        switch (objectType) {
            case "customer":
                Customer customer=(Customer)object;
                printWriter.append("Customer Added : Name\\" +
                    customer.getFname() + customer.getLname() +
                    ",Email\\" + customer.getEmail() +
                    ",Address\\" + customer.getAddress() +
                    ",Mobile\\" + customer.getMobile() +
                    ",Gender\\" + customer.getGender()+
                    ",Date\\"+ Instant.now());
                    break;
            case "product":
                System.out.println("product added");
                Product product=(Product)object;
                printWriter.append("Product Added : Name\\"+
                        product.getName()+
                        ",Category\\"+product.getCategory()+
                        ",Price\\"+product.getPrice()+
                        ",Quantity\\"+product.getQuantity()+
                        ",Description\\"+product.getDescription()+
                        ",Date\\"+Instant.now());
                    break;
            case "order":
                Order order=(Order) object;
                printWriter.append("Order Added : product\\"+
                        order.getProduct()+
                        ",customer\\"+order.getCustomer().getFname()+order.getCustomer().getFname()+
                        ",Quantity\\"+order.getQuantity()+
                        ",Price\\"+order.getTotalPrice()+
                        ",Date\\"+ Instant.now());


                break;



            }
        printWriter.println();
        writer.close();
        printWriter.close();
    }
}
