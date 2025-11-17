package com.product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductCRUDOperation {
	public static String url="jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root";
	public static Connection con;
	static Scanner scan=new Scanner(System.in);

	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	  public  static void insertProduct() throws SQLException {
			PreparedStatement cs= con.prepareStatement("insert into product values(?,?,?)");
			System.out.println("Enter the product ID");
			cs.setInt(1, scan.nextInt());
			System.out.println("Enter the product name:");
			cs.setString(2, scan.next());
			System.out.println("Entre the product price:");
			cs.setDouble(3, scan.nextDouble());
			cs.execute();
			System.out.println("Product inserted Successfully.");
			
		}
	  
	  public  static void insertProducts() throws SQLException {
			CallableStatement cs= con.prepareCall("call insert_product(?,?,?)");
			System.out.println("Enter the product ID");
			cs.setInt(1, scan.nextInt());
			System.out.println("Enter the product name:");
			cs.setString(2, scan.next());
			System.out.println("Entre the product price:");
			cs.setDouble(3, scan.nextDouble());
			cs.execute();
			System.out.println("Product inserted Successfully.");
			
		}
	  
	  
	  public  static void updateProductPrice() throws SQLException {
			PreparedStatement cs= con.prepareStatement("update  product set price=? where id=?");
			System.out.println("Enter the product ID");
			System.out.println("Enter the product id");
			cs.setInt(1, scan.nextInt());
			System.out.println("Entre the new price for the product:");
			cs.setDouble(2, scan.nextDouble());
			cs.execute();
			System.out.println("Product price updated Successfully.");
			
		}
	  
	  public  static void deleteProduct() throws SQLException {
			PreparedStatement cs= con.prepareStatement("delete from product where id=?");
			System.out.println("Enter the product ID which you want to delete");
			cs.setInt(1, scan.nextInt());
			cs.execute();
			System.out.println("Product deleted Successfully.");
			
		}
	  
	  public  static void findById() throws SQLException {
			PreparedStatement cs= con.prepareStatement("select * from product where id=?");
			System.out.println("Enter the product ID which you want to delete");
			cs.setInt(1, scan.nextInt());
			ResultSet rs=cs.executeQuery();
			
			while(rs.next()) {
				System.out.println("id:" + rs.getInt(1)+ " Name:" +rs.getString(2) + " Price:" +rs.getDouble(3));
				return;
			}
			System.out.println("Product not found .");
			
		}
	  public  static void findByPrice() throws SQLException {
			PreparedStatement cs= con.prepareStatement("select * from product where price=?");
			System.out.println("Enter the product price to find the product");
			cs.setDouble(1, scan.nextDouble());
			ResultSet rs=cs.executeQuery();
			
			
			while(rs.next()) {
				System.out.println("id:" + rs.getInt(1)+ " Name:" +rs.getString(2) + " Price:" +rs.getDouble(3));
				
			}
//			System.out.println("Product not found .");
			
		}
	  
	  public  static void findAll() throws SQLException {
			PreparedStatement cs= con.prepareStatement("select * from product");
			
			ResultSet rs=cs.executeQuery();
			
			while(rs.next()) {
				System.out.println("id:" + rs.getInt(1)+ " Name:" +rs.getString(2) + " Price:" +rs.getDouble(3));
				
			}
	  }
	  
	  public static void closeConnection() throws SQLException {
		  con.close();
		  System.out.println("connection closes.");
		  
	  }
	  
	  
			
		public static void whatYouWantToDo() throws SQLException {
			System.out.println("Enter 1 for the insert the product, 2 for the insert product using the stored procedure,3 for the find by id 4 th for the find all.");
			int choice;
			while(true) {
				System.out.println("Enter the choice:");
				choice=scan.nextInt();
	           switch(choice)	{
	           case 1:{
	        	   insertProduct();
	        	   break;
	           }
	           case 2:{
	        	   insertProducts();
	        	   break;
	           }
	           case 3:{
	        	   findById();
	        	   break;
	           }
	           case 4:{
	        	   
	        	   findAll();
	        	   break;
	           }
	           default:{
	        	   break;
	        	   
	           }
	           }
	           System.out.println("Thank you:");
	           return;
			}
		}
	  
	  
	public static void main(String[] args) {
		
		try {
			whatYouWantToDo();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
