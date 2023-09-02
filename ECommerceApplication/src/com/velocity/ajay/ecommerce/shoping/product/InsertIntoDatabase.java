package com.velocity.ajay.ecommerce.shoping.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoDatabase {

	public void UserRegistration(String firstName, String lastName, String username, String password, String city,
			String email, String mobile_no) throws SQLException {
		// call getConnection() method
		ConnectionTest connectionTest = new ConnectionTest();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionTest.getConnection();
			// step 3: Prepare sql Statement
			preparedStatement = connection.prepareStatement(
					"insert into user_registration(firstname,lastname,username,password,city,email,mobile_no) values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, city);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, mobile_no);

			// step 4:Submit the Sql Query to database
			int insert = preparedStatement.executeUpdate();
			System.out.println("Your Registration is Successfull");
			// step 5: Process the result:done internally

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}

}
