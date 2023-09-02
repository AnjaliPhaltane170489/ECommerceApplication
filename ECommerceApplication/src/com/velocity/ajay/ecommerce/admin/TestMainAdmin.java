package com.velocity.ajay.ecommerce.admin;

import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("resource")
public class TestMainAdmin {

	public static void main(String[] args) {

		CreateTableProduct createTableProduct = new CreateTableProduct();
		try {
			createTableProduct.getCreateTableAdmin();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ProductDetails productDetails = new ProductDetails();
		System.out.println("Enter how many you add product>>");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for (int i = 1; i <= num; i++) {
			productDetails.getProductDetails();
		}
	}
}
