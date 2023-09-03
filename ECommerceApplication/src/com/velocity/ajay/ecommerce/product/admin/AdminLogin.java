package com.velocity.ajay.ecommerce.product.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {

	public void getAdminLoginDetails() throws SQLException {

		System.out.println("Enter the username>>");
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.next();
		System.out.println("Enter the password>>");
		String password = scanner.next();
		String sql = "select username,password from adminregister where password=?";
		ConnectionAdmin connectionAdmin = new ConnectionAdmin();
		Connection connection = connectionAdmin.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String databaseUsername = resultSet.getString("username");
				String databasePassword = resultSet.getString("password");
				if (databaseUsername.equals(userName)) {
					if (databasePassword.equals(password)) {
						System.out.println("Admin Login Successfull.....");
					}
				} else {
					System.err.println("Admin Login Unsuccessfull, Please check again username & password......");
				}

			} else {
				System.err.println("Admin Login Unsuccessfull, Please check again username & password......");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}
}
