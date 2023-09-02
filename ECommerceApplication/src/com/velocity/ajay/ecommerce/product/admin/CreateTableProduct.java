package com.velocity.ajay.ecommerce.product.admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableProduct {

	public void getCreateTableAdmin() throws SQLException {

		ConnectionAdmin connectionAdmin = new ConnectionAdmin();
		Connection connection = connectionAdmin.getConnection();
		Statement statement = null;
		try {

			String sql = "create table product(id int(10) primary key auto_increment not null,productid int(10),"
					+ "productname varchar(255)," + "productdescription varchar(255),productquntity int(10),"
					+ "productprice varchar(150))";
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
