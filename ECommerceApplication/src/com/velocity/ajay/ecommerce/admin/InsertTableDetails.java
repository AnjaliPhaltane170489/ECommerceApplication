package com.velocity.ajay.ecommerce.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTableDetails {

	public void getInsertDetails(int id, String name, String description, int quntity, float price)
			throws SQLException {

		ConnectionAdmin connectionAdmin = new ConnectionAdmin();
		Connection connection = connectionAdmin.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("insert into product(productid,productname,productdescription,"
							+ "productquntity,productprice)values(?,?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, description);
			preparedStatement.setInt(4, quntity);
			preparedStatement.setFloat(5, price);
			int value = preparedStatement.executeUpdate();
			System.out.println("Product added into database>>>>> " + value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}
}
