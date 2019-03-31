package application;



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
    ArrayList<String> Item = new ArrayList<String>();
    public static final String[] ItemUnique = {"Shoes","Blazer","Pendrive","Tie","Watch","T-Shirt","Headphones","WirelessMouse","Laptop","Pen","LaptopSkin","Belt","Socks","Women Shoes","BasketBall"};
    
    @FXML
    private Button logout;
    private String selected_item="";
    @FXML
    private Button checkout;
    //Receive message from scene 1
    @FXML private ListView<String> listView;
    static String userName;
    @FXML
    private Label recommend;
    @FXML
    private Label text_recommend;
    public void sendMessage(String message) {
        //Display the message
    	userName=message;
        display.setText(userName);
        
    }
    public void sendProduct(String s) {
        selected_item=s;
    	ObservableList<String> items = listView.getItems();
    	for(int i=0;i<Login.itemList.size();i++)
    	{
    		String it = Login.itemList.get(i);
    		items.add(it);
    	}
    	

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
	text_recommend.setText("Customer who bought "+selected_item+" also bought :");
	recommend.setText(suggest);
	
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
    @FXML
    public void CheckoutButtonAction(ActionEvent event) {
    	Window owner = checkout.getScene().getWindow();
    	
    	AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "", 
              userName + "! You Bought these items\n"+Login.itemList);
    	
//    	DBConnector.Connection();

    	Connection con = null;
    	Statement stmt = null;
    	String query = "INSERT INTO `recosys`.`items` (`items`) VALUES ('"+Login.itemList+"')";
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
    	Login.itemList.clear();
    	listView.getItems().clear();
}
    }
