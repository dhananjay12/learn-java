package mynotes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcTest {

	public Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306", "root", "admin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
	
	public void testDb(){
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			statement=connection.createStatement();
			rs=statement.executeQuery("Select * from test.employee");
			showResultSet(rs);
			ps=connection.prepareStatement("Insert into test.employee values (?,?,?,?,?)");
			ps.setInt(1,200);
			ps.setString(2, "Jane");
			ps.setString(3, "Doe");
			ps.setInt(4, 32);
			ps.setInt(5, 5500);
			int rowModified=ps.executeUpdate();
			System.out.println("RowModified=>"+rowModified);
			rs=statement.executeQuery("Select * from test.employee");
			showResultSet(rs);
			rs.close();
			statement.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public void showResultSet(ResultSet rs) throws SQLException{
		  for  (int i = 1; i<= rs.getMetaData().getColumnCount(); i++){
		      System.out.print(rs.getMetaData().getColumnName(i)+"\t");
		    }
		 System.out.println();
		 while(rs.next()){
			 System.out.print(rs.getInt(1)+"\t");
			 System.out.print(rs.getString(2)+"\t");
			 System.out.print(rs.getString(3)+"\t");
			 System.out.print(rs.getInt(4)+"\t");
			 System.out.print(rs.getInt(5));
			 System.out.println();
			 
			
		 }
		    
	}

	public static void main(String[] args) {
		JdbcTest aJdbcTest=new JdbcTest();
		aJdbcTest.testDb();
	}

}
