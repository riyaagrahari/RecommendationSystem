package application;

import javafx.beans.property.SimpleStringProperty;
//import javafx.util.Callback;

public class Person {

	
	 private final SimpleStringProperty iName;
	 Person(String iName){
		 this.iName = new SimpleStringProperty(iName);
	 }
	 public String getFirstName() {
         return iName.get();
     }

     public void setFirstName(String fName) {
         iName.set(fName);
     }
}
