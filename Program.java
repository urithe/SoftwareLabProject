import java.sql.Connection;
import Users.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import DBPackage.*;
import DBPackage.DBConnection;
import Users.UserClass;
public class Program {

	public static void main(String[] args) throws Exception {
		DBConnection dbconn=new DBConnection();
		// TODO Auto-generated method stub
		try
		{
			ArrayList<UserClass> allUsers=UserClass.allUsersList("UserID"); 
			for (UserClass user : allUsers)//foreach user  
			{
				System.out.println("id="+user.getUserID()+"\npass="+user.getUserPassword());	
			}//end foreach
		
		}//end try
		catch(Exception e){System.out.println(e);}
		
	}
	


}
