
import java.util.ArrayList;

import Users.StudentClass;
import Users.UserClass;
public class Program {

	public static void main(String[] args) throws Exception
	{
		UserClass.loginForm();
		StudentClass someone=new StudentClass("3013");
		System.out.println("the student " + someone.getUserID() + " in class " + someone.getStudentClass().getClassName());
		try
		{
			ArrayList<UserClass> allUsers=UserClass.allUsersList("UserID"); 
			System.out.println("All Users:");
			for (UserClass user : allUsers)//for each user  
			{
				System.out.println("id="+user.getUserID()+"\npass="+user.getUserPassword());	
			}//end for each
		
		}//end try
		catch(Exception e){System.out.println(e);}
				
		
	}//end main
	


}//end class program
