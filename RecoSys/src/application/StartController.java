package application;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StartController extends Application {

	public static ArrayList <String> itemList = new ArrayList <String>();
	public static String welcome_name="";
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
//        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.getIcons().add(new Image(StartController.class.getResourceAsStream("logo_icon.png")));
        primaryStage.setTitle("Customer Portal");
        primaryStage.setScene(new Scene(root, 590, 480));
        primaryStage.show();
    }
    @FXML
    public void startAction(ActionEvent event) {
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
    
  
    public static void main(String[] args) {
    	
        launch(args);
    }
}