package commonFunctions;

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
}
