package net.javaguides.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPostgreSQLConnect {
	private final String url = "jdbc:postgresql://localhost/postgres";
	private final String user = "postgres";
	private final String password = "";
	
	private void connect() {
		try(Connection connection = DriverManager.getConnection(url, user, password);) {
			if(connection != null) {
				System.out.println("Connected to Postgresql");
			}else {
				System.out.println("Failed");
			}
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT VERSION()");
			if(resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JDBCPostgreSQLConnect sqlConnect = new JDBCPostgreSQLConnect();
		sqlConnect.connect();
	}
}
