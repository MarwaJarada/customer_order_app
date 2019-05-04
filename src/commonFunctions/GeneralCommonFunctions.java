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




    public static void openNewScene(Class myClass,AnchorPane from , String to) throws IOException {
        Stage stage=(Stage)from.getScene().getWindow();
        FXMLLoader loader=new FXMLLoader(myClass.getResource(to));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        stage.setScene(scene);

    }

    public static void closeScene(AnchorPane pane){
        Stage stage=(Stage)pane.getScene().getWindow();
        stage.close();
    }

    public static void openNewStage(Class myClass,String to) throws IOException {
        Stage stage=new Stage();
        FXMLLoader loader=new FXMLLoader(myClass.getResource(to));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        stage.setScene(scene);
        stage.show();

    }


}

