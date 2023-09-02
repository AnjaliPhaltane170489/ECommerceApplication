package com.velocity.ajay.ecommerce.product.user;

import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration {

	public void Register() throws SQLException {
		System.out.println("WELCOME TO E-COMMERSE APPLICATION ");
		System.out.println("Enter First Name>>");
		Scanner scanner = new Scanner(System.in);
		String fname = scanner.next();
		System.out.println("Enter Last Name>>");
		String lastname = scanner.next();
		System.out.println("Enter  UserName>>");
		String username = scanner.next();
		System.out.println("Enter Password>>");
		String password = scanner.next();
		System.out.println("Enter the City>>");
		String city = scanner.next();
		System.out.println("Enter the Mail Id>>");
		String email = scanner.next();
		System.out.println("Enter the Mobile Number>>");
		String mobile = scanner.next();
		InsertIntoDatabase insertIntoDatabase = new InsertIntoDatabase();
		insertIntoDatabase.UserRegistration(fname, lastname, username, password, city, email, mobile);

	}
}
