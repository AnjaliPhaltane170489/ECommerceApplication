package com.velocity.ajay.ecommerce.shoping.product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	
	//create a table user registration

		public void createTable() throws SQLException {
			String str="create table user_registration (id int (10) not null auto_increment,firstname varchar(255),lastname varchar(255),username varchar(255),password varchar(255),city varchar(255),email varchar(255),mobile_no varchar(255),primary key(id))";
			
			ConnectionTest connectionTest1=new ConnectionTest();
			Connection connection=null;
			Statement statement=null;
			
			try {
				 connection=connectionTest1.getConnection();
				statement=connection.createStatement();
				int a=statement.executeUpdate(str);
				System.out.println("User Registration table created successfully");
				  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				connection.close();
				statement.close();
			}
		}

	}

