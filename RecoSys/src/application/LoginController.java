package application;


import java.io.IOException;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {
    @FXML
    private TextField nameField;


    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;
    private static final String USERNAME_REGEX = "^[a-zA-Z][a-zA-Z0-9]+$";
    
    private static final Pattern USERNAME_PATTERN = 
                                        Pattern.compile(USERNAME_REGEX);
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        Window owner = submitButton.getScene().getWindow();
        if(nameField.getText().isEmpty() || !USERNAME_PATTERN.matcher(nameField.getText()).matches()){
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter a valid name");
            return;
        }
        
 
        if(passwordField.getText().isEmpty() || passwordField.getText().length() < 6) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter a valid password");
            return;
        }

//        Node node=(Node) event.getSource();
//        Stage stage=(Stage) node.getScene().getWindow();
        Parent root2 = null;
        FXMLLoader loader = null;
		try {
			  loader = new FXMLLoader(getClass().getResource("second.fxml"));
			  root2 = loader.load();
			//root2 = FXMLLoader.load(getClass().getResource("second.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/* Exception */
       
		WelcomeController welcomeController = loader.<WelcomeController>getController();
       welcomeController.sendMessage(nameField.getText());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene2 = new Scene(root2);
        window.setScene(scene2);
        window.show();
//        AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", 
//                "Welcome " + nameField.getText());
    }
}
