package DBPackage;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	private Connection conn;
	public DBConnection() throws Exception//constructor
	{
		this.conn=getConnection();
	}//end constructor
	
	public Connection getConn(){return this.conn;}
	
	public static Connection getConnection() throws Exception
	{
		
		try
		{
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/maindb";
			String username="root";
			String password="amirbeno";
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,password);
			return conn;
		}//end try
		catch(Exception e){System.out.println(e);}
		return null;
		
		
	}
}
