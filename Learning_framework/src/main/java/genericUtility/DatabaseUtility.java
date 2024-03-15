package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con;
	
	// this method is to create a the connection with the DB
	public void connectToDB() {
		try {

			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(IpathConstants.dbURL,IpathConstants.dbUsername,IpathConstants.dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//this method is to close the db 
	public void closeDB() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// this method is to execute the query and the get the data 
	public String excuteQueryAndReturnData(String query,int columnNo,String expData) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			String value= result.getString(columnNo);
			if(value.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		if(flag=true){
			return expData;
		}
		else {
			return "";
		}
		
	}

}
