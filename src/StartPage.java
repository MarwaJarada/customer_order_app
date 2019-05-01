import controllers.AddCustomerController;
import db.DbConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartPage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("view\\customer_add.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        DbConnection dbConnection=DbConnection.getConnection();

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

