package application;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import javafx.stage.Window;
import javafx.stage.Window;

public class WelcomeController {
    @FXML
    private Label name;
    @FXML
    public Label display;
    String item;
    public static ObservableList<String> items;
    ArrayList<String> Item = new ArrayList<String>();
    public static final String[] ItemUnique = {"Shoes","Blazer","Pendrive","Tie","Watch","T-Shirt","Headphones","WirelessMouse","Laptop","Pens","LaptopSkin","Belt","Socks","WomenHeels","BasketBall"};
    
    @FXML
    private Button logout;
    private String selected_item="";
    @FXML
    private Button checkout;
    @FXML
    ImageView item_img; 
    @FXML private ListView<String> listView;
    static String userName;
    @FXML
    private Label recommend;
    @FXML
    private Label text_recommend;
    
    String Item_url= "C:/Users/Riya Agrahari/git/RecoSys/images/";
    public void sendMessage(String message, String name) {
        //Display the message
    	userName=message;
    	  
    	StartController.welcome_name=message;
        display.setText(userName);
        
    }
    public void sendProduct(String s, String m) throws FileNotFoundException {
        selected_item=s;
        if (s == "" && listView.getItems() == null)
        	{text_recommend.setText("Looks like your cart is empty! Check out our most popular item");
        	 text_recommend.setTextFill(Color.web("#ff0000"));
        	}
        	
    	 items = listView.getItems();
    	for(int i=0;i<StartController.itemList.size();i++)
    	{
    		String it = StartController.itemList.get(i);
    		items.add(it);
    		
    		//listView.getItems().clear();
    		
    	}
    	display.setText(userName);
    	

    	Connection con = null;
    	Statement stmt = null;
    	ResultSet rs = null;
    	int max=0;
    	String suggest="";
    	int x=0;
try{
	con = (Connection) DBConnector.getConnection();
	stmt= (Statement) con.createStatement();
	System.out.println(selected_item);
	for(int i =0;i<15;i++)
	{
		 if(ItemUnique[i].equals(selected_item))
		 continue;
		 else
		 {
    rs = stmt.executeQuery("Select count(*) from `recosys`.`items` where items like'%" + selected_item + "%' and items like '%"+ ItemUnique[i] + "%'"); 
    
		 while(rs.next()){
	    x = rs.getInt("COUNT(*)");	
	    
	    System.out.println(ItemUnique[i]+" "+selected_item+" "+x);
	  }
//    x = rs.getInt("total");
   
    if (x>max)
    	{max=x;
    	 suggest=ItemUnique[i];
    	}
	}
	}

    
	System.out.println("Suggested Item: "+suggest);
	if (s != "" && listView.getItems() != null)
	{
	text_recommend.setText("People who bought "+selected_item+" also bought :");
	Item_url = Item_url + suggest+".png"; 
	recommend.setText(suggest);
	
	File file = new File(Item_url);
	System.out.println(Item_url);
    Image image = new Image(file.toURI().toString());
    item_img.setImage(image);
	}
	if (s == "" && listView.getItems() != null)
	{
	text_recommend.setText("Looks like you didn't select anything. Have a look at our most popular item");
	Item_url = Item_url + suggest+".png"; 
	recommend.setText(suggest);
	text_recommend.setTextFill(Color.web("#ff0000"));
	text_recommend.setFont(new Font("Comic Sans MS", 18));
	
	File file = new File(Item_url);
	System.out.println(Item_url);
    Image image = new Image(file.toURI().toString());
    item_img.setImage(image);
	}
	//Image image = new Image(new FileInputStream(Item_url));
	//item_img.setImage(Item_url);
	
//    	while(rs.next())  
//    	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  ");  
}
catch(SQLException e){
	e.printStackTrace();
}
finally{
	try{
    	con.close();  
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	}
    	
}
           
    	
    	

//    		TableColumn<DataModelClass, String> column = new TableColumn<DataModelClass, String>(item);
//    	column.setCellValueFactory(new PropertyValueFactory<DataModelClass, String>("nameList"));
    	
    
    @FXML
    public void logoutButtonAction(ActionEvent event) {
       // Window owner = logout.getScene().getWindow();
        Parent root1 = null;
        FXMLLoader loader2 = null;
        items.clear();
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
	        StartController.itemList.clear();
	        
	      
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
    @FXML
    public void CheckoutButtonAction(ActionEvent event) {
    	Window owner = checkout.getScene().getWindow();
    	
    	AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "", 
              userName + "! You Bought these items\n"+StartController.itemList);
    	
//    	DBConnector.Connection();

    	Connection con = null;
    	Statement stmt = null;
    	String query = "INSERT INTO `recosys`.`items` (`items`) VALUES ('"+StartController.itemList+"')";
try{
	con = (Connection) DBConnector.getConnection();
	stmt= (Statement) con.createStatement();
    stmt.executeUpdate(query);  
//    	while(rs.next())  
//    	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  ");  
}
catch(SQLException e){
	e.printStackTrace();
}
finally{
	try{
    	con.close();  
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	}
    	StartController.itemList.clear();
    	listView.getItems().clear();
    	
    	text_recommend.setText("");
    	recommend.setText("");
    	Item_url="";
    	File file = new File(Item_url);
    	System.out.println(Item_url);
        Image image = new Image(file.toURI().toString());
        item_img.setImage(image);
}
    }
