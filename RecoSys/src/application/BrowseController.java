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
	 @FXML private RadioButton rb5;
	 @FXML private RadioButton rb6;
	 @FXML private RadioButton rb7;
	 @FXML private RadioButton rb8;
	 @FXML private RadioButton rb9;
	 @FXML private RadioButton rb10;
	 @FXML private RadioButton rb11;
	 @FXML private RadioButton rb12;
	 @FXML private RadioButton rb13;
	 @FXML private RadioButton rb14;
	 @FXML private RadioButton rb15;
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
			if(rb5.isSelected())
	        {
				i=rb5.getText();
				Login.itemList.add(rb5.getText());
				 				 System.out.println(rb5.getText());
	        }
			if(rb6.isSelected())
	        {
				i=rb6.getText();
				Login.itemList.add(rb6.getText());
				 				 System.out.println(rb6.getText());
	        }
			if(rb7.isSelected())
	        {
				i=rb7.getText();
				Login.itemList.add(rb7.getText());
				 				 System.out.println(rb7.getText());
	        }
			if(rb8.isSelected())
	        {
				i=rb8.getText();
				Login.itemList.add(rb8.getText());
				 				 System.out.println(rb8.getText());
	        }
			if(rb9.isSelected())
	        {
				i=rb9.getText();
				Login.itemList.add(rb9.getText());
				 				 System.out.println(rb9.getText());
	        }
			if(rb10.isSelected())
	        {
				i=rb10.getText();
				Login.itemList.add(rb10.getText());
				 				 System.out.println(rb10.getText());
	        }
			if(rb11.isSelected())
	        {
				i=rb11.getText();
				Login.itemList.add(rb11.getText());
				 				 System.out.println(rb11.getText());
	        }
			if(rb12.isSelected())
	        {
				i=rb12.getText();
				Login.itemList.add(rb12.getText());
				 				 System.out.println(rb12.getText());
	        }
			if(rb13.isSelected())
	        {
				i=rb13.getText();
				Login.itemList.add(rb13.getText());
				 				 System.out.println(rb13.getText());
	        }
			if(rb14.isSelected())
	        {
				i=rb14.getText();
				Login.itemList.add(rb14.getText());
				 				 System.out.println(rb14.getText());
	        }
			if(rb15.isSelected())
	        {
				i=rb15.getText();
				Login.itemList.add(rb15.getText());
				 				 System.out.println(rb15.getText());
	        }
			
			welcomeController.sendProduct(i);

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