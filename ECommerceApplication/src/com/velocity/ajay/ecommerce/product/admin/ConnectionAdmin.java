package com.velocity.ajay.ecommerce.product.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionAdmin {
	public Connection getConnection() throws SQLException {
		Connection connection = null;
		// step 1:Loading the Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// step 2:establish the Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "Sanket@5055");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
