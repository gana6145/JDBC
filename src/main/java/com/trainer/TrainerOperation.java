package com.trainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TrainerOperation {
	
	private static String URL="jdbc:postgresql://localhost:5432/trainer?user=postgres&password=root";
	static Connection con;
	static Scanner scan=new Scanner(System.in);
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(URL);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	public static void insertData() throws SQLException {
		PreparedStatement stm=con.prepareStatement("insert into trainer values(?,?,?,?)");
		System.out.println("Enter the trainer id:");
		stm.setInt(1,scan.nextInt());
		System.out.println("Enter the name of the trainer:");
		stm.setString(2, scan.next());
		System.out.println("Enter the sal of the trainer:");
		stm.setDouble(3, scan.nextDouble());
		System.out.println("Enter the trainer subject:");
		stm.setString(4, scan.next());
		int n =stm.executeUpdate();
		System.out.println(n+"rows inserted");
	}
	
	
	public static void fetchData() throws SQLException {
		PreparedStatement stm=con.prepareStatement("select * from trainer order by id");
		ResultSet rs=stm.executeQuery();
		
		while(rs.next()) {
			System.out.println("Trainer_Id : " + rs.getInt(1) + " Trainer_name: " + rs.getString(2)+ " sir Trainer_salary: " + rs.getString(3)+"rs Subject: "+ rs.getString(4));
		}
		
	}
	
	
	public static void fetchById() throws SQLException {
		PreparedStatement stm=con.prepareStatement("select * from trainer where id=?");
		System.out.println("Enter the trainer id:");
		stm.setInt(1,scan.nextInt());
		ResultSet rs=stm.executeQuery();
		
		while(rs.next()) {
			System.out.println("Trainer_Id : " + rs.getInt(1) + " Trainer_name: " + rs.getString(2)+ " sir Trainer_salary: " + rs.getString(3)+"rs Subject: "+ rs.getString(4));
		}
		
	}
	
	public static void updateName() throws SQLException {
		PreparedStatement stm=con.prepareStatement("update trainer set name=? where id=?");
		System.out.println("Enter the trainer id:");
		stm.setInt(2, scan.nextInt());
		System.out.println("Enter the new name of the trainer:");
		stm.setString(1, scan.next());
		System.out.println(stm.executeUpdate()+ " rows affected");
	}
	
	
	public static void updateSallary() throws SQLException {
		PreparedStatement stm=con.prepareStatement("update trainer set sal=? where id=?");
		System.out.println("Enter the trainer id:");
		stm.setInt(2, scan.nextInt());
		System.out.println("Enter the new sallary:");
		stm.setDouble(1, scan.nextDouble());
		System.out.println(stm.executeUpdate()+ " rows affected");
	}
	public static void updateSubject() throws SQLException {
		PreparedStatement stm=con.prepareStatement("update trainer set subject=? where id=?");
		System.out.println("Enter the trainer id:");
		stm.setInt(2, scan.nextInt());
		System.out.println("Enter the name of the subject:");
		stm.setString(1, scan.next());
		System.out.println(stm.executeUpdate()+ " rows affected");
	}
	
	
	public static void deleteById() throws SQLException {
		PreparedStatement stm=con.prepareStatement("delete from trainer where id=?");
		System.out.println("Enter the trainer id:");
		stm.setInt(1,scan.nextInt());
		int n=stm.executeUpdate();
		System.out.println(n+" rows affected");
	}
	
	public static void updateUserInfo() throws SQLException {
		System.out.println("Enter the choice what u want to update:");
		System.out.println("Enter 1 for the update name");
		System.out.println("Enter 2 for the update sal");
		System.out.println("Enter 3 for the update subject");
		int num=scan.nextInt();
		switch(num) {
		case 1:{
			updateName();
			break;
			
		}
        case 2:{
        	updateSallary();
        	break;
			
		}
        case 3:{
        	updateSubject();
        	break;
        }
       default:{
    	   System.out.println("invalid choice");
    	   break;
       }
		
		}
		
	}
	
	
	public static void closeConnection() throws SQLException {
		con.close();
		System.out.println("connection close successfully");
	}
	
	
	

	public static void main(String[] args) {
		try {
			updateUserInfo();
							
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
