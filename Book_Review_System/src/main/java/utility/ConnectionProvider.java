package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionProvider {
	
	private static Connection connection=null;

	private ConnectionProvider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection()
	{
		if(connection==null)
		{
			String url = "jdbc:mysql://localhost:3306/bookreview";
			try {
				connection=DriverManager.getConnection(url,"root","MySQL@29");
			} catch (SQLException e) {
			  	System.out.println("Something Went wrong while connecting with DB");
			}
		}
		return connection;
	}
	
	

}
