package com.velocity.ajay.ecommerce.product.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminRegistration {

	public void getAdminDetails() throws SQLException {

		System.out.println("Enter the First Name>>");
		Scanner scanner = new Scanner(System.in);
		String fName = scanner.next();
		System.out.println("Enter the Last Name>>");
		String lName = scanner.next();
		System.out.println("Enter the Phone Number>>");
		String mNumber = scanner.next();
		System.out.println("Enter the Email ID");
		String email = scanner.next();
		System.out.println("Enter the User Name");
		String uName = scanner.next();
		System.out.println("Enter the Password");
		String pass = scanner.next();

		insertAdminDetails(fName, lName, mNumber, email, uName, pass);
	}

	private void insertAdminDetails(String fName, String lName, String mNumber, String email, String uName, String pass)
			throws SQLException {

		ConnectionAdmin connectionAdmin = new ConnectionAdmin();
		Connection connection = connectionAdmin.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"insert into adminregister(firstname,lastname,mobilenumber,emailid,username,password)values(?,?,?,?,?,?)");
			preparedStatement.setString(1, fName);
			preparedStatement.setString(2, lName);
			preparedStatement.setString(3, mNumber);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, uName);
			preparedStatement.setString(6, pass);
			int value = preparedStatement.executeUpdate();
			System.out.println("Admin Registered>>>>" + value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}

	public static void main(String[] args) throws SQLException {
		CreateTableAdmin admin = new CreateTableAdmin();
		admin.getCreateTableAdmin();
		System.err.println("Admin Register Table Created.......");

		AdminRegistration adminRegistration = new AdminRegistration();
		adminRegistration.getAdminDetails();

	}
}
