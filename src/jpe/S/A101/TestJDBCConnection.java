package jpe.S.A101;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCConnection {
	public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=JavaCoreBai14";
	public static final String USER = "sa";
	public static final String PW = "P90rushbnonstop!";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("aaaa");
			String connectionUrl = URL + ";trustServerCertificate=true";
			conn = DriverManager.getConnection(connectionUrl, USER, PW);
			System.out.println("bbbb");
			System.out.println("KET NOI THANH CONG");
		} catch (SQLException e) {
			System.err.println("Connect fail");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

    public static void main(String[] args) {
    	System.out.println("1");
    	Connection connect = getConnection();
    	System.out.println("2");
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
			while (rs.next()) {
				System.out.println("co record");
			}
			connect.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
}