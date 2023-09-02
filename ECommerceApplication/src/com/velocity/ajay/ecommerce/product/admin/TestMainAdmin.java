package com.velocity.ajay.ecommerce.product.admin;

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
		System.out.println("Welcome to  ADMIN VIEW of E-Commerce based Application>>>");
		System.out.println("Enter the Operation You want to perform>>>");
		System.out.println("7:Add Product Item");
		System.out.println("8:Calculate Bill");
		System.out.println("9:Display Amount to End User");
		System.out.println("10:Check Quantity");
		System.out.println("11:CheckedRegistered User");
		System.out.println("12:Check the particular User History");
		System.out.println("ENter Your choice");
		Scanner scanner=new Scanner(System.in);
		int ch=scanner.nextInt();
		 switch(ch) {
		 case 7:
			 ProductDetails productDetails=new ProductDetails();
			 System.out.println("Enter how many you add product>>");
				
				int num = scanner.nextInt();
				for (int i = 1; i <= num; i++) {
					productDetails.getProductDetails();
				}
			 break;
			 
		 }

		ProductDetails productDetails = new ProductDetails();
		
	}
}
