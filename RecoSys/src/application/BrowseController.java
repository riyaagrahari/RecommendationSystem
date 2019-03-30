package application;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
//import javafx.stage.Window;

public class BrowseController {
	
	 @FXML private Button doneButton;
	 @FXML private RadioButton rb1;
	 @FXML private RadioButton rb2;
	 @FXML private RadioButton rb3;
	 @FXML private RadioButton rb4;
	 @FXML
	final ToggleGroup group = new ToggleGroup();
//	 Login ob = new Login();
	@FXML
    protected void BrowseButtonAction(ActionEvent event) {
		
        Parent root1 = null;
        FXMLLoader loader2 = null;
        
		try {
			
			  loader2 = new FXMLLoader(getClass().getResource("second.fxml"));
			  
			 
				root1 = loader2.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/* Exception */
		
        
//        welcomeController.sendProduct(rb1.getText());
		 WelcomeController welcomeController = loader2.<WelcomeController>getController();
		 String i = "";
			if(rb1.isSelected())
	        {
				i=rb1.getText();
				Login.itemList.add(rb1.getText());
				 				 System.out.println(rb1.getText());
	        }
			if(rb2.isSelected())
	        {
				i=rb2.getText();
				Login.itemList.add(rb2.getText());
				 				 System.out.println(rb2.getText());
	        }
			if(rb3.isSelected())
	        {
				i=rb3.getText();
				Login.itemList.add(rb3.getText());
				 				 System.out.println(rb3.getText());
	        }
			if(rb4.isSelected())
	        {
				i=rb4.getText();
				Login.itemList.add(rb4.getText());
				 				 System.out.println(rb4.getText());
	        }
			welcomeController.sendProduct();

	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        Scene scene2 = new Scene(root1);
	        window.setScene(scene2);
	        window.show();

	        

}
	@FXML
	protected void RadioClickAction(ActionEvent event) {

//		
		 
}
}