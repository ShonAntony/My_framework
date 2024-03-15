package testClassAndMethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseTest {

	public static void main(String[] args) throws SQLException {

		// here initially we need to create the driver class object
		Driver driver = new Driver();
		// call the static method from the driver manager "registerDriver()" and pass
		// the driver as a actual argument
		DriverManager.registerDriver(driver);
		// in the below connection statement we are going to pass the DB URI and once we
		// the database
		// name as the endpoint along with the username and password
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "Shonantony123#");
		// here we can initially create a statement and then using that statement variable we can execute the query 
		ResultSet res = con.createStatement().executeQuery("SELECT * FROM test;");
		// here we are running the while loop to get all the column values based on the index
		while (res.next()) {
			for (int i = 1; i < 4; i++) {
				System.out.print(res.getString(i)+" ");
			}
			System.out.println();
			
		}
		con.close();
	}

}