package application;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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
    public static final String[] ItemUnique = {"Shoes","BasketBall","Headphones","Watch","WirelessMouse","T-Shirt","Tie","Socks","Pendrive","Laptop","Belt","LaptopSkin","Pens","WomenHeels","Blazer","Bedsheet","Cricket-Bat","Helmet","Blanket","Knee-Guard","StudyLamp","ToothBrush","Cushion","Flower vase","Sunglasses","Mobile-BackCover","Dress","Notebook","Gloves","Mobile","Earrings","Chair","Wallet","Perfumes","ToothPaste","Air-Conditioner","Bottle","FaceWash","Pencil","Table","Induction-CookTops","Television","TongueCleaner","Cricket-Ball","Induction-Cookware","Tempered Glass","Bag","Purse","Soap","TableCloth"};
    
    @FXML
    private Button logout;
    private String selected_item="";
    @FXML
    private Button checkout;
    @FXML
    ImageView item_img;
    @FXML
    ImageView item_img1;
    @FXML
    ImageView item_img2;
    @FXML private ListView<String> listView;
    static String userName;
    @FXML
    private Label recommend;
    @FXML
    private Label text_recommend;
    @FXML
    private Label plus1;
    @FXML
    private Label plus2;
    
    String Item_url= "C:/Users/Riya Agrahari/git/RecoSys/images/";
    String Item1_url= "C:/Users/Riya Agrahari/git/RecoSys/images/";
    String Item2_url= "C:/Users/Riya Agrahari/git/RecoSys/images/";
    public void sendMessage(String message, String name) {
        //Display the message
    	userName=message;
    	  
    	StartController.welcome_name=message;
        display.setText(userName);  
        
        Connection con = null;
     	Statement stmt = null;
     	ResultSet rs = null;
     	String oldCart = "";
        try{
        	con = (Connection) DBConnector.getConnection();
        	stmt= (Statement) con.createStatement();
        	rs = stmt.executeQuery("Select `cartItems` from `recosys`.`userlogin` where userName like'%" + userName + "%' "); 
        	 while(rs.next()){
        		    oldCart = rs.getString("cartItems");
        		    }
        	 oldCart = oldCart.substring(1);
        	 System.out.println(oldCart);
        	 oldCart = oldCart.substring(0, oldCart.length() - 1);
        	 System.out.println(oldCart);
        	 String[] ary = oldCart.split(",");
        	 for (int i = 0; i < ary.length; i++)
        		    ary[i] = ary[i].trim();
        	 System.out.println(ary);
        	 StartController.itemList = new ArrayList<String>(Arrays.asList(ary));
        	 items = listView.getItems();
        	 	for(int i=0;i<StartController.itemList.size();i++)
        	 	{
        	 		String it = StartController.itemList.get(i);
        	 		//if(flag == true)
        	 		items.add(it);
        	 		
        	 		//listView.getItems().clear();
        	 		
        	 	}
        	 System.out.println(StartController.itemList);
        	
        }catch (Exception e){
        	System.out.println(e);
        }
    }
    
    
    public void sendProduct(String s, String m) throws FileNotFoundException {
        selected_item=s;
      
        
        if(StartController.itemList.size() == 1){
        	twoChecker(selected_item,true);
        }
        else{
        	threeChecker(selected_item); //this will call twoChecker(selected_item); if needed
        }
    }

    
// Two Combination Checker
    public void twoChecker(String s, Boolean flag)
    {
    	 if (s == "" && listView.getItems() == null)
     	{text_recommend.setText("Looks like your cart is empty! Check out our most popular item");
     	 text_recommend.setTextFill(Color.web("#ff0000"));
     	}
     	
 	 items = listView.getItems();
 	for(int i=0;i<StartController.itemList.size();i++)
 	{
 		String it = StartController.itemList.get(i);
 		if(flag == true)
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
	for(int i =0;i<50;i++)
	{
		 if(ItemUnique[i].equals(selected_item) || StartController.itemList.contains(ItemUnique[i]))
		 continue;
		 else
		 {
 rs = stmt.executeQuery("Select count(*) from `recosys`.`items` where items like'%" + selected_item + "%' and items like '%"+ ItemUnique[i] + "%'"); 
 
		 while(rs.next()){
	    x = rs.getInt("COUNT(*)");	
	    
	    System.out.println(ItemUnique[i]+" "+selected_item+" "+x);
	  }
// x = rs.getInt("total");

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
	Item_url = Item_url + suggest+".gif"; 
	recommend.setText(suggest);
	Item1_url = Item1_url + selected_item +".gif";
	
	File file = new File(Item_url);
	System.out.println(Item_url);
	Image image = new Image(file.toURI().toString());
	item_img.setImage(image);
	File file1 = new File(Item1_url);
	System.out.println(Item1_url);
	Image image1 = new Image(file1.toURI().toString());
	item_img1.setImage(image1);
	plus1.setText("+");
	plus2.setText("");
	}
	if (s == "" && listView.getItems() != null)
	{
	text_recommend.setText("Looks like you didn't select anything. Have a look at our most popular item");
	Item_url = Item_url + suggest+".gif"; 
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
	
// 	while(rs.next())  
// 	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  ");  
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
    
    
    
//Three Combination Checkerr4
    public void threeChecker(String s)
    {
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
	for(int i =0;i<50;i++)
	{
		 if(ItemUnique[i].equals(selected_item) || StartController.itemList.contains(ItemUnique[i]))
		 continue;
		 else
		 {
			 int l = StartController.itemList.size();
			 String item1 = StartController.itemList.get(l-2).toString();
			// String item2 = StartController.itemList.get(size).toString();
			 
 rs = stmt.executeQuery("Select count(*) from `recosys`.`items` where items like'%" + selected_item + "%' and items like'%" + item1 + "%' and items like '%"+ ItemUnique[i] + "%'"); 
 
		 while(rs.next()){
	    x = rs.getInt("COUNT(*)");	
	    
	    System.out.println(ItemUnique[i]+" "+selected_item+" "+item1+ " " +x);
	  }
// x = rs.getInt("total");

 if (x>max)
 	{max=x;
 	 suggest=ItemUnique[i];
 	}
 
	}
	}
	
	if(max == 0){twoChecker(s,false);}
		
	else
	{

 
	System.out.println("Suggested Item: "+suggest);
	if (s != "" && listView.getItems() != null)
	{
		int l= StartController.itemList.size();
		String item2 = StartController.itemList.get(l-2).toString();
	text_recommend.setText("People who bought "+selected_item+" and "+item2+" also bought :");
	Item_url = Item_url + suggest+".gif"; 
	recommend.setText(suggest);
	Item1_url = Item1_url + selected_item +".gif";
	Item2_url = Item2_url + item2+".gif";
	
	plus1.setText("+");
	plus2.setText("+");
	File file = new File(Item_url);
	System.out.println(Item_url);
 Image image = new Image(file.toURI().toString());
 item_img.setImage(image);
 
 File file1 = new File(Item1_url);
	System.out.println(Item1_url);
Image image1 = new Image(file1.toURI().toString());
item_img1.setImage(image1);

File file2 = new File(Item2_url);
System.out.println(Item2_url);
Image image2 = new Image(file2.toURI().toString());
item_img2.setImage(image2);
	}
	if (s == "" && listView.getItems() != null)
	{
	text_recommend.setText("Looks like you didn't select anything. Have a look at our most popular item");
	Item_url = Item_url + suggest+".gif"; 
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
	
// 	while(rs.next())  
// 	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  ");  
}}
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

     	Connection con = null;
     	Statement stmt = null;
     	ResultSet rs = null;
     
    	String query = "UPDATE `recosys`.`userlogin` SET `CartItems` = '"+StartController.itemList+"' WHERE (`UserName` = '"+userName+"')";
    	//UPDATE `recosys`.`userlogin` SET `CartItems` = '[Shoes, FaceWash,Pens]' WHERE (`UserName` = 'segdh');
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
        //items.clear();
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