package com.velocity.ajay.ecommerce.shoping.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	public void loginUser() throws SQLException {
		System.out.println("Enter Username");
		Scanner scanner = new Scanner(System.in);
		String enteredUsername = scanner.next();
		System.out.println("Enter Password");
		String enteredPassword = scanner.next();
		String sql = "select password from user_registration where username=?";
		ConnectionTest connectionTest = new ConnectionTest();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionTest.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, enteredUsername);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String databasePassword = resultSet.getString("password");
				if (enteredPassword.equals(databasePassword)) {
					System.out.println("Login Successfull");
				} else {
					System.out.println("You are not Registered!!! To continue Register with E-Commerce Application");

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}

}
