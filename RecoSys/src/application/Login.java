package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Login extends Application {

	public static ArrayList <String> itemList = new ArrayList <String>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("first.fxml"));
        //primaryStage.getIcons().add(new Image("C:/Users/Riya%Agrahari/git/RecoSys/images/icon.png"));
        primaryStage.setTitle("Customer Portal");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
    	
        launch(args);
    }
}