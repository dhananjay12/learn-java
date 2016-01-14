package mynotes.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NewJava7ExceptionSyntex {
	
	public Connection getConnection()  {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306", "root", "admin");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception => "+e.getMessage());
		}finally{
			System.out.println("FINAL");
		}
		
		System.out.println("DO SOMETHING");

		return connection;
	}

	public void readUsingTryWithResource() {
		try(BufferedReader br = new BufferedReader(new FileReader("MyText.txt"))) {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        System.out.println("File Contents==");
	        System.out.println(everything);
	    } catch (IOException e) {
	    	System.out.println("IOException => "+e.getMessage());
		}

	}

	public static void main(String[] args) {
		NewJava7ExceptionSyntex aNewJava7ExceptionSyntex=new NewJava7ExceptionSyntex();
		aNewJava7ExceptionSyntex.getConnection();
		aNewJava7ExceptionSyntex.readUsingTryWithResource();
		System.out.println("End");
	}

}
