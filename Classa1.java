package pkga1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Classa1 {
	//static final String JDBC_DRIVER="com.mysql.jdbc.Driver"; 
	static final String DB_URL="jdbc:mysql://localhost/employee";
	static final String user="root";
	static final String PASS="Tester###@";



	public static void main(String[] args) {
		Connection conn =null;
		Statement stmt=null;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("connection to database");
	conn=DriverManager.getConnection(DB_URL,"root","Tester###@");
	System.out.println("creating statement");
	stmt=conn.createStatement();
	String sql;
	sql="SELECT * FROM employees ";
	ResultSet rs=stmt.executeQuery(sql);
	while(rs.next())
	{
		int id=rs.getInt("id");
		int age =rs.getInt("age");
		String first=rs.getString("first");
		String last= rs.getString("last");
		System.out.println("id "+id);
		System.out.println("age "+age);
		System.out.println("first "+first);
		System.out.println("last "+last);
	}
	//step 6: cleanup environment
	rs.close();
	stmt.close();
	conn.close();
	
}
catch(SQLException se)
{
	se.printStackTrace();
}

catch(Exception e)
{
	e.printStackTrace();
}


finally 
{
	try {
		if(stmt!=null)
			stmt.close();
	}
	catch(SQLException se2)
	{
		
	}

	try {
	if(conn!=null)
		conn.close();
	}
	catch(SQLException se)
	{
		
	}
	}
System.out.println("goodbye");
}
}