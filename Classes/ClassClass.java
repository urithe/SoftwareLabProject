package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBPackage.DBConnection;

public class ClassClass {
	/************************ V A R I A B L E S ************************/
	private int classID;
	private String className;
	/************************ C O N S T R U C T O R S ************************/
	public ClassClass(int classID) throws Exception//constructor by classID
	{
		try
		{
			DBConnection dbconn=new DBConnection();
			String sqlQuery="SELECT * FROM Classes WHERE ClassID="+classID;
			PreparedStatement sql=dbconn.getConn().prepareStatement(sqlQuery);
			ResultSet rs=sql.executeQuery();
			if(rs.next())//has data
			{
				this.setClassID(rs.getInt("ClassID"));
				this.setClassName(rs.getString("ClassName"));
			}//end while
			
		}//end try
		catch(Exception e){System.out.println(e);}
		
	}//end constructor by Classid


	/************************ G E T  &  S E T ************************/
	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
