package application;

import java.sql.*;  
class DBConnector{  
	public static DBConnector instance = new DBConnector();
	public final static String URL="jdbc:mysql://localhost:3306/recosys";
	public final static String user = "root";
	public final static String password = "root";
public void DBConnector(){ 

try{  
Class.forName("com.mysql.jdbc.Driver");
}
catch(ClassNotFoundException e){
	e.printStackTrace();
}
}
public Connection createConnection(){
	Connection con=null;
	try{
con=DriverManager.getConnection( URL,user,password);  
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return con;
}
public static Connection getConnection(){
	return instance.createConnection();
//Statement stmt=con.createStatement();  
//ResultSet rs=stmt.executeQuery("select * from items");  
//while(rs.next())  
//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  ");  
//con.close();  
  
}
}  