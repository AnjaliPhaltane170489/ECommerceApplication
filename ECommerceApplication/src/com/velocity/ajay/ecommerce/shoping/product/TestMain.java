package com.velocity.ajay.ecommerce.shoping.product;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) throws SQLException {
		try {
			createTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Welcome to E-Commerce based Application>>>");
		System.out.println("Enter the Operation You want to perform>>>");
		System.out.println("1:User Registration");
		System.out.println("2:User Login");
		System.out.println("3:User View Product Items as Sorted Order");
		System.out.println("4:Buy Product");
		System.out.println("5:View Cart");
		System.out.println("6:Purchase the Item");
		System.out.println("ENter Your choice");
		Scanner scanner = new Scanner(System.in);
		int ch = scanner.nextInt();
		switch (ch) {
		case 1:
			UserRegistration userRegistration = new UserRegistration();
			userRegistration.Register();
			break;
		case 2:
			UserLogin userLogin = new UserLogin();
			userLogin.loginUser();
			break;
		}
	}

	public static void createTable() throws SQLException {
		String str = "create table user_registration (id int (10) not null auto_increment,firstname varchar(255),lastname varchar(255),username varchar(255),password varchar(255),city varchar(255),email varchar(255),mobile_no varchar(255),primary key(id))";

		ConnectionTest connectionTest1 = new ConnectionTest();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionTest1.getConnection();
			statement = connection.createStatement();
			int a = statement.executeUpdate(str);
			System.out.println("User Registration table created successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}
	}
}
