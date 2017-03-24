package Users;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBPackage.DBConnection;
import Classes.*;
public class StudentClass extends UserClass 
{
	private ClassClass studentClass;
	/************************ C O N S T R U C T O R S ************************/
	public StudentClass(String studentID) throws Exception
	{
		super(studentID);//calling the user class
		try
		{
			DBConnection dbconn=new DBConnection();
			String sqlQuery="SELECT * FROM Students WHERE StudentID="+studentID;
			PreparedStatement sql=dbconn.getConn().prepareStatement(sqlQuery);
			ResultSet rs=sql.executeQuery();
			if(rs.next())//has data
			{
				this.setStudentClass(new ClassClass(rs.getInt("ClassID")));//getting the student's class object
			}//end while
		}//end try
		catch(Exception e){System.out.println(e);}
			
	}//end constructor by studentID

	
	/************************ G E T  &  S E T ************************/
	public ClassClass getStudentClass()
	{
		return this.studentClass;
	}

	public void setStudentClass(ClassClass classObject)
	{
		this.studentClass = classObject;
	}
	
	
	/************************ O B J E C T   F U N C T I O N S ************************/
	
	
	/************************ S T A T I C    F U N C T I O N S ************************/
}//end class
