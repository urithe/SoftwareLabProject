package Users;
import DBPackage.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserClass {
	private String userID;
	private String password;
	
	public UserClass(String userID) throws Exception//constructor by userID
	{
		try
		{
			DBConnection dbconn=new DBConnection();
			String sqlQuery="SELECT * FROM Users WHERE UserID='"+userID+"'";
			PreparedStatement posted=dbconn.getConn().prepareStatement(sqlQuery);
			
			ResultSet rs=posted.executeQuery();
			while(rs.next())//has data
			{
				this.userID=rs.getString("UserID");
				this.password=rs.getString("Password");
			}//end while
			
		}//end try
		catch(Exception e){System.out.println(e);}
		
	}//end constructor by userid
	
	
	
	
	/************************ G E T  &  S E T ************************/
	public String getUserID(){return this.userID;}
	public String getUserPassword(){return this.password;}
	
	
/************************ S T A T I C    F U N C T I O N S ************************/
	public static void createNewUser(String userID) throws Exception
	{
		try
		{
			DBConnection dbconn=new DBConnection();
			String sqlQuery="INSERT INTO Users (UserID) VALUES ('"+userID+"')";
			PreparedStatement posted=dbconn.getConn().prepareStatement(sqlQuery);
			posted.executeUpdate();
			
		}
		catch(Exception e){System.out.println(e);}
		
	}//end create new user
	
	public static ArrayList<UserClass> allUsersList(String orderBy)  throws Exception
	//gives array list with all of the users order by required field
	{
		ArrayList<UserClass> outputList=new ArrayList<UserClass>();
		try
		{
			DBConnection dbconn=new DBConnection();
			String sqlQuery="SELECT UserID FROM Users ORDER BY "+orderBy;//get the users order by required field
			PreparedStatement posted=dbconn.getConn().prepareStatement(sqlQuery);
			
			ResultSet rs=posted.executeQuery();
			while(rs.next())//has data
				outputList.add(new UserClass(rs.getString("UserID")));//adding user object to the list
			
		}//end try
		catch(Exception e){System.out.println(e);}
		
		return outputList;
	}//end all users list
}
