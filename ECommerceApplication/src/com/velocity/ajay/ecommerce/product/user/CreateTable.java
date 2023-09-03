package com.velocity.ajay.ecommerce.product.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//create a table user registration
public class CreateTable {

	public void createTable() throws SQLException {
		String str = "create table user_registration (id int (10) not null auto_increment,firstname varchar(255),lastname varchar(255),username varchar(255),password varchar(255),city varchar(255),email varchar(255),mobile_no varchar(255),primary key(id))";

		ConnectionTest connectionTest1 = new ConnectionTest();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionTest1.getConnection();
			statement = connection.createStatement();
			int a = statement.executeUpdate(str);
			System.out.println("User Registration table created successfully>>> " + a);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}
	}
}
