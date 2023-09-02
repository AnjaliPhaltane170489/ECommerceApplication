package com.velocity.ajay.ecommerce.product.admin;

import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("resource")
public class ProductDetails {

	public void getProductDetails() {
		System.out.println("Enter product id>>");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		System.out.println("Enter product name>>");
		String name = scanner.next();
		System.out.println("Enter product description>>");
		String description = scanner.next();
		System.out.println("Enter product quntity>>");
		int quntity = scanner.nextInt();
		System.out.println("Enter product price>>");
		float price = scanner.nextFloat();

		InsertTableDetails details = new InsertTableDetails();
		try {
			details.getInsertDetails(id, name, description, quntity, price);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			scanner.close();
		}
	}
}
