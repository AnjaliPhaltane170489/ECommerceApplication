package com.velocity.ajay.ecommerce.shoping.product;

import java.sql.SQLException;

public class TestMain {

	public static void main(String[] args) {
		CreateTable createTable = new CreateTable();
		try {
			createTable.createTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Welcome to E-Commerce based Application>>>");
		System.out.println("Enter the Operation You want to perform>>>");
		int ch = 1;
		// switch(ch)
	}
}
