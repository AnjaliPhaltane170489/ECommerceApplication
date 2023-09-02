package com.velocity.ajay.ecommerce.product.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BuyProduct {
	public void userBuyProductDetails() throws SQLException {
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
				String productName = resultSet.getString("productname");
				String productDescription=resultSet.getString("productdescription");
			    int quantity = resultSet.getInt("productquntity");
                double price = resultSet.getDouble("productprice");
            

                // Check if the product is in stock
                if (quantity > 0) {
                    System.out.println("Product found: " );
                    System.out.println("Product Name>>"+ productName);
                    System.out.println("Product Description>>"+ productDescription);
                    System.out.println("Available quantity: " + quantity);
                    System.out.println("Price: $" + price);
                    

                    // Confirm the purchase
                    System.out.print("Do you want to purchase this product? (Y/N): ");
                    char purchaseChoice = scanner.next().charAt(0);

                    if (purchaseChoice == 'Y' || purchaseChoice == 'y') {
                        // Perform the purchase
                        // Here,  update the quantity and perform other necessary operations
                       

                        // Update the product quantity 
                        String updateQuantityQuery = "UPDATE product SET quantity = ? WHERE product_id = ?";
                        int updatedQuantity = quantity - 1; // Reduce the quantity by 1
                        PreparedStatement updateStatement = connection.prepareStatement(updateQuantityQuery);
                        updateStatement.setInt(1, updatedQuantity);
                        updateStatement.setInt(2, enteredId);
                        int rowsUpdated = updateStatement.executeUpdate();

                        if (rowsUpdated > 0) {
                            System.out.println("Purchase successful. Thank you!");
                        } else {
                            System.out.println("Failed to update product quantity. Purchase aborted.");
                        }
                    } else {
                        System.out.println("Purchase aborted.");
                    }
                } else {
                    System.out.println("Sorry, the product is out of stock.");
                }
            } else {
                System.out.println("Product not found with ID: " + enteredId);
            }
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
		
		
		
	}

}
