package commonFunctions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

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


}
