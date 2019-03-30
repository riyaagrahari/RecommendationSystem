package application;

import javafx.beans.property.SimpleStringProperty;
//import javafx.util.Callback;

public class Item {

	
	 private final SimpleStringProperty IName = new SimpleStringProperty("");;
	 Item(String IName){
		setiName(IName);
	 }
	 public String getiName() {
         return IName.get();
     }

     public void setiName(String iName2) {
         IName.set(iName2);
     }
}
