package commonFunctions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class GeneralCommonFunctions {


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

    public static void openNewScene(Class myClass,AnchorPane from , String to) throws IOException {
        Stage stage=(Stage)from.getScene().getWindow();
        FXMLLoader loader=new FXMLLoader(myClass.getResource(to));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        stage.setScene(scene);

    }
}

