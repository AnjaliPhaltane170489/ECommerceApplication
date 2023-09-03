package com.velocity.ajay.ecommerce.product.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateBill {

	public void getCalculateBill() throws SQLException {

		ConnectionAdmin connectionAdmin = new ConnectionAdmin();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionAdmin.getConnection();
			preparedStatement = connection.prepareStatement("select productprice from product where id = (?)");
			preparedStatement.setFloat(1, 1);
			ResultSet resultSet = preparedStatement.executeQuery();
			double totalBill = 0;
			while (resultSet.next()) {
				System.out.println("Product Price>> " + resultSet.getFloat(1));

				totalBill += resultSet.getDouble("productprice");

				System.out.println();
			}
			System.out.println("Total Bill>> " + totalBill);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}
}
