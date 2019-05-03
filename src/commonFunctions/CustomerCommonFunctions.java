package commonFunctions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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
}
