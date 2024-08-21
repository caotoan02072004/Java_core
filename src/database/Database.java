package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;

import javax.management.RuntimeErrorException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Database {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=Class","sa", "1234$");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
