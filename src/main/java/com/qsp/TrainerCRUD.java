package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TrainerCRUD {
	
	static String URL="jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root";
	static Scanner scan= new Scanner(System.in);
	static Connection con;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root");
		    
		    
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void insertTrainer() throws SQLException{
		   PreparedStatement stm =con.prepareStatement("insert into trainer values(?,?,?)");
		   System.out.println("Enter the id");
		   stm.setInt(1, scan.nextInt());
		   System.out.println("Enter the name of the tariner");
		   stm.setString(2,scan.next());
		   System.out.println("Enter the suject of the trainer");
		   stm.setString(3, scan.next());
		   int n =stm.executeUpdate();
		   System.out.println(n+" rows inserted");
	}
	
	public static void fetchById() throws SQLException{
		 PreparedStatement stm =con.prepareStatement("select * from trainer where id=?");
		 System.out.println("Enter te id to get the trainer:");
		 stm.setInt(1, scan.nextInt());
		 ResultSet rs=stm.executeQuery();
		 
		 while(rs.next()) {
			 System.out.println(rs.getInt("id")+" " + rs.getString("name") + " " + rs.getString("subject"));
		}
		
		
		
	}
	public static void fetchAll() throws SQLException{
		 PreparedStatement stm =con.prepareStatement("select * from trainer");
		 ResultSet rs=stm.executeQuery();
		 
		 while(rs.next()) {
			 System.out.println(rs.getInt("id")+" " + rs.getString("name") + " " + rs.getString("subject"));
		}
		
		
		
	}
	
	
	public static void updateTrainerSubject() throws SQLException{
		 PreparedStatement stm =con.prepareStatement("update trainer set subject=? where id=? ");
		 stm.setString(1, scan.next());
		 stm.setInt(1, scan.nextInt());
		 int rs=stm.executeUpdate();
		 System.out.println(rs +"rows affected");
		 
		 
		
		
		
	}

	public static void main(String[] args) {
		try {
			
			updateTrainerSubject();
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
