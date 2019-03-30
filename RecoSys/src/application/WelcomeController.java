package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import javafx.stage.Window;

public class WelcomeController {
    @FXML
    private Label name;
    public Label display;
//    private Button logout;
    //Receive message from scene 1
    public void sendMessage(String message) {
        //Display the message
        display.setText(message);
    }
    public void logoutButtonAction(ActionEvent event) {
        //Window owner = logout.getScene().getWindow();
        Parent root1 = null;
        FXMLLoader loader2 = null;
		try {
			  loader2 = new FXMLLoader(getClass().getResource("first.fxml"));
			  root1 = loader2.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/* Exception */
		 Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        Scene scene1 = new Scene(root1);
	        window.setScene(scene1);
	        window.show();
}
    public void BrowseButtonAction(ActionEvent event) {
        //Window owner = logout.getScene().getWindow();
        Parent root1 = null;
        FXMLLoader loader2 = null;
		try {
			  loader2 = new FXMLLoader(getClass().getResource("third.fxml"));
			  root1 = loader2.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/* Exception */
		 Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        Scene scene1 = new Scene(root1);
	        window.setScene(scene1);
	        window.show();
}  
}