package com.velocity.ajay.ecommerce.product.user;
import com.velocity.ajay.ecommerce.product.admin.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ViewProductItemsSortedOrder {
	public void viewProductItems() throws SQLException {
		ConnectionAdmin connectionAdmin = new ConnectionAdmin();
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
        connection= connectionAdmin.getConnection();
         preparedStatement=connection.prepareStatement("select * from product order by id ASC");
       resultSet=preparedStatement.executeQuery();
        while(resultSet.next()) {
        	System.out.println("ProductId>>"+resultSet.getInt(1));
        	System.out.println("Product Name>>"+resultSet.getString(2));
        	System.out.println("Product Description>>"+resultSet.getString(3));
        	System.out.println("Product Quantity>>"+resultSet.getString(4));
        	System.out.println("Product Price>>"+resultSet.getString(5));
        }
		}
        catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
			
			
		}
        }
	

}

