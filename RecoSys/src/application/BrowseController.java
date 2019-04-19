package application;

import java.io.FileNotFoundException;
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
	 @FXML private RadioButton rb16;
	 @FXML private RadioButton rb17;
	 @FXML private RadioButton rb18;
	 @FXML private RadioButton rb19;
	 @FXML private RadioButton rb20;
	 @FXML private RadioButton rb21;
	 @FXML private RadioButton rb22;
	 @FXML private RadioButton rb23;
	 @FXML private RadioButton rb24;
	 @FXML private RadioButton rb25;
	 @FXML private RadioButton rb26;
	 @FXML private RadioButton rb27;
	 @FXML private RadioButton rb28;
	 @FXML private RadioButton rb29;
	 @FXML private RadioButton rb30;
	 @FXML private RadioButton rb31;
	 @FXML private RadioButton rb32;
	 @FXML private RadioButton rb33;
	 @FXML private RadioButton rb34;
	 @FXML private RadioButton rb35;
	 @FXML private RadioButton rb36;
	 @FXML private RadioButton rb37;
	 @FXML private RadioButton rb38;
	 @FXML private RadioButton rb39;
	 @FXML private RadioButton rb40;
	 @FXML private RadioButton rb41;
	 @FXML private RadioButton rb42;
	 @FXML private RadioButton rb43;
	 @FXML private RadioButton rb44;
	 @FXML private RadioButton rb45;
	 @FXML private RadioButton rb46;
	 @FXML private RadioButton rb47;
	 @FXML private RadioButton rb48;
	 @FXML private RadioButton rb49;
	 @FXML private RadioButton rb50;
	 
	 @FXML
	final ToggleGroup group = new ToggleGroup();
	 

	   private void closeStage() 
	    {
	      ((Stage) doneButton.getScene().getWindow()).close();
	    }
	@FXML
    protected void BrowseButtonAction(ActionEvent event) throws FileNotFoundException {
		
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
				StartController.itemList.add(rb1.getText());
				 				 System.out.println(rb1.getText());
	        }
			if(rb2.isSelected())
	        {
				i=rb2.getText();
				StartController.itemList.add(rb2.getText());
				 				 System.out.println(rb2.getText());
	        }
			if(rb3.isSelected())
	        {
				i=rb3.getText();
				StartController.itemList.add(rb3.getText());
				 				 System.out.println(rb3.getText());
	        }
			if(rb4.isSelected())
	        {
				i=rb4.getText();
				StartController.itemList.add(rb4.getText());
				 				 System.out.println(rb4.getText());
	        }
			if(rb5.isSelected())
	        {
				i=rb5.getText();
				StartController.itemList.add(rb5.getText());
				 				 System.out.println(rb5.getText());
	        }
			if(rb6.isSelected())
	        {
				i=rb6.getText();
				StartController.itemList.add(rb6.getText());
				 				 System.out.println(rb6.getText());
	        }
			if(rb7.isSelected())
	        {
				i=rb7.getText();
				StartController.itemList.add(rb7.getText());
				 				 System.out.println(rb7.getText());
	        }
			if(rb8.isSelected())
	        {
				i=rb8.getText();
				StartController.itemList.add(rb8.getText());
				 				 System.out.println(rb8.getText());
	        }
			if(rb9.isSelected())
	        {
				i=rb9.getText();
				StartController.itemList.add(rb9.getText());
				 				 System.out.println(rb9.getText());
	        }
			if(rb10.isSelected())
	        {
				i=rb10.getText();
				StartController.itemList.add(rb10.getText());
				 				 System.out.println(rb10.getText());
	        }
			if(rb11.isSelected())
	        {
				i=rb11.getText();
				StartController.itemList.add(rb11.getText());
				 				 System.out.println(rb11.getText());
	        }
			if(rb12.isSelected())
	        {
				i=rb12.getText();
				StartController.itemList.add(rb12.getText());
				 				 System.out.println(rb12.getText());
	        }
			if(rb13.isSelected())
	        {
				i=rb13.getText();
				StartController.itemList.add(rb13.getText());
				 				 System.out.println(rb13.getText());
	        }
			if(rb14.isSelected())
	        {
				i=rb14.getText();
				StartController.itemList.add(rb14.getText());
				 				 System.out.println(rb14.getText());
	        }
			if(rb15.isSelected())
	        {
				i=rb15.getText();
				StartController.itemList.add(rb15.getText());
				 				 System.out.println(rb15.getText());
	        }
			if(rb16.isSelected())
	        {
				i=rb16.getText();
				StartController.itemList.add(rb16.getText());
				 				 System.out.println(rb16.getText());
	        }
			if(rb17.isSelected())
	        {
				i=rb17.getText();
				StartController.itemList.add(rb17.getText());
				 				 System.out.println(rb17.getText());
	        }
			if(rb18.isSelected())
	        {
				i=rb18.getText();
				StartController.itemList.add(rb18.getText());
				 				 System.out.println(rb18.getText());
	        }
			if(rb19.isSelected())
	        {
				i=rb19.getText();
				StartController.itemList.add(rb19.getText());
				 				 System.out.println(rb19.getText());
	        }
			if(rb20.isSelected())
	        {
				i=rb20.getText();
				StartController.itemList.add(rb20.getText());
				 				 System.out.println(rb20.getText());
	        }
			if(rb21.isSelected())
	        {
				i=rb21.getText();
				StartController.itemList.add(rb21.getText());
				 				 System.out.println(rb21.getText());
	        }
			if(rb22.isSelected())
	        {
				i=rb22.getText();
				StartController.itemList.add(rb22.getText());
				 				 System.out.println(rb22.getText());
	        }
			if(rb23.isSelected())
	        {
				i=rb23.getText();
				StartController.itemList.add(rb23.getText());
				 				 System.out.println(rb23.getText());
	        }
			if(rb24.isSelected())
	        {
				i=rb24.getText();
				StartController.itemList.add(rb24.getText());
				 				 System.out.println(rb24.getText());
	        }
			if(rb25.isSelected())
	        {
				i=rb25.getText();
				StartController.itemList.add(rb25.getText());
				 				 System.out.println(rb25.getText());
	        }
			if(rb26.isSelected())
	        {
				i=rb26.getText();
				StartController.itemList.add(rb26.getText());
				 				 System.out.println(rb26.getText());
	        }
			if(rb27.isSelected())
	        {
				i=rb27.getText();
				StartController.itemList.add(rb27.getText());
				 				 System.out.println(rb27.getText());
	        }
			if(rb28.isSelected())
	        {
				i=rb28.getText();
				StartController.itemList.add(rb28.getText());
				 				 System.out.println(rb28.getText());
	        }
			if(rb29.isSelected())
	        {
				i=rb29.getText();
				StartController.itemList.add(rb29.getText());
				 				 System.out.println(rb29.getText());
	        }
			if(rb30.isSelected())
	        {
				i=rb30.getText();
				StartController.itemList.add(rb30.getText());
				 				 System.out.println(rb30.getText());
	        }
			if(rb31.isSelected())
	        {
				i=rb31.getText();
				StartController.itemList.add(rb31.getText());
				 				 System.out.println(rb31.getText());
	        }
			if(rb32.isSelected())
	        {
				i=rb32.getText();
				StartController.itemList.add(rb32.getText());
				 				 System.out.println(rb32.getText());
	        }
			if(rb33.isSelected())
	        {
				i=rb33.getText();
				StartController.itemList.add(rb33.getText());
				 				 System.out.println(rb33.getText());
	        }
			if(rb34.isSelected())
	        {
				i=rb34.getText();
				StartController.itemList.add(rb34.getText());
				 				 System.out.println(rb34.getText());
	        }
			if(rb35.isSelected())
	        {
				i=rb35.getText();
				StartController.itemList.add(rb35.getText());
				 				 System.out.println(rb35.getText());
	        }
			if(rb36.isSelected())
	        {
				i=rb36.getText();
				StartController.itemList.add(rb36.getText());
				 				 System.out.println(rb36.getText());
	        }
			if(rb37.isSelected())
	        {
				i=rb37.getText();
				StartController.itemList.add(rb37.getText());
				 				 System.out.println(rb37.getText());
	        }
			if(rb38.isSelected())
	        {
				i=rb38.getText();
				StartController.itemList.add(rb38.getText());
				 				 System.out.println(rb38.getText());
	        }
			if(rb39.isSelected())
	        {
				i=rb39.getText();
				StartController.itemList.add(rb39.getText());
				 				 System.out.println(rb39.getText());
	        }
			if(rb40.isSelected())
	        {
				i=rb40.getText();
				StartController.itemList.add(rb40.getText());
				 				 System.out.println(rb40.getText());
	        }
			if(rb41.isSelected())
	        {
				i=rb41.getText();
				StartController.itemList.add(rb41.getText());
				 				 System.out.println(rb41.getText());
	        }
			if(rb42.isSelected())
	        {
				i=rb42.getText();
				StartController.itemList.add(rb42.getText());
				 				 System.out.println(rb42.getText());
	        }
			if(rb43.isSelected())
	        {
				i=rb43.getText();
				StartController.itemList.add(rb43.getText());
				 				 System.out.println(rb43.getText());
	        }
			if(rb44.isSelected())
	        {
				i=rb44.getText();
				StartController.itemList.add(rb44.getText());
				 				 System.out.println(rb44.getText());
	        }
			if(rb45.isSelected())
	        {
				i=rb45.getText();
				StartController.itemList.add(rb45.getText());
				 				 System.out.println(rb45.getText());
	        }
			if(rb46.isSelected())
	        {
				i=rb46.getText();
				StartController.itemList.add(rb46.getText());
				 				 System.out.println(rb46.getText());
	        }
			if(rb47.isSelected())
	        {
				i=rb47.getText();
				StartController.itemList.add(rb47.getText());
				 				 System.out.println(rb47.getText());
	        }
			if(rb48.isSelected())
	        {
				i=rb48.getText();
				StartController.itemList.add(rb48.getText());
				 				 System.out.println(rb48.getText());
	        }
			if(rb49.isSelected())
	        {
				i=rb49.getText();
				StartController.itemList.add(rb49.getText());
				 				 System.out.println(rb49.getText());
	        }
			if(rb50.isSelected())
	        {
				i=rb50.getText();
				StartController.itemList.add(rb50.getText());
				 				 System.out.println(rb50.getText());
	        }
			
			
			
			
			welcomeController.sendProduct(i,StartController.welcome_name);
			closeStage();
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