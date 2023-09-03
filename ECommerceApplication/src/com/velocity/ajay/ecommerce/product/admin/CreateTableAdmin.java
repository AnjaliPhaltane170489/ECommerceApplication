package com.velocity.ajay.ecommerce.product.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableAdmin {

	public void getCreateTableAdmin() throws SQLException {

		ConnectionAdmin connectionAdmin = new ConnectionAdmin();
		Connection connection = connectionAdmin.getConnection();
		Statement statement = null;
		try {

			String sql = "create table adminregister(id int(10) primary key auto_increment not null,firstname varchar(255),"
					+ "lastname varchar(255),mobilenumber varchar(150),emailid varchar(255),username varchar(255),"
					+ "password varchar(255))";
			statement = connection.createStatement();
			int value = statement.executeUpdate(sql);
			System.out.println("Table Created>>>>> " + value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}
	}
}
