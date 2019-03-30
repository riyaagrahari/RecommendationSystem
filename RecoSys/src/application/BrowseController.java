package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class BrowseController {
	
	private Button doneButton;

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
		 Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        Scene scene1 = new Scene(root1);
	        window.setScene(scene1);
	        window.show();

}
}