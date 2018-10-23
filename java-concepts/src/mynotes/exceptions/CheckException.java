package mynotes.exceptions;

import java.io.IOError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckException {
	
	public Connection getConnection()  {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306", "root", "admin");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		} catch (SQLException e) {
			System.out.println("SQLException=>"+e.getMessage());
			//throw new SQLException("SQLException");
		}finally{
			System.out.println("FINAL");
		}
		
		System.out.println("DO SOMETHING");

		return connection;
	}
	
	
	
	
	private void getDetails() {
	    throw new UnsupportedOperationException("Not yet implemented");
	}
	
	private void readFile(String filename) throws IOException{
		
		if(!filename.contains("."))
		throw new IOException("File Name Invalid");
	}

	
	public static void main(String[] args) {
		CheckException aCheckException=new CheckException();
		Connection con = aCheckException.getConnection();
	
		System.out.println("Con=>"+con);
		
		//aCheckException.getDetails();
		
		try {
			aCheckException.readFile("asd");
		} catch (IOException e) {
			System.out.println("IOException=>"+e.getMessage());
		}
		
		
	}

}
