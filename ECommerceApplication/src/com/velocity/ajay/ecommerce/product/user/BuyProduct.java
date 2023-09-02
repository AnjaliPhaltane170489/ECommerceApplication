package com.velocity.ajay.ecommerce.product.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BuyProduct {
	public void userBuyProductDetails() {
		System.out.println("Enter the Product Id to Buy the Product>> ");
		Scanner scanner=new Scanner(System.in);
		int enteredId=scanner.nextInt();
		String sql = "select * from product where productid=?";
		ConnectionTest connectionTest=new ConnectionTest();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=connectionTest.getConnection();
			 preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, enteredId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				int databaseId=resultSet.getInt("productid");
				if(enteredId==databaseId) {
					System.out.println("The Entered ProductId Information is:");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		
		
		
	}

}
