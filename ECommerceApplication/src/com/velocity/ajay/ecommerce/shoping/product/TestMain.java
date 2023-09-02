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
	}
}
