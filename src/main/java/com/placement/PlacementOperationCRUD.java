package com.placement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PlacementOperationCRUD {
	private static String URL="jdbc:postgresql://localhost:5432/qsp";
	private static String user="postgres";
	private static String password="root";
	static Connection con;
	static Scanner scan=new Scanner(System.in);
	
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(URL,user,password);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public static void insertStudent() throws SQLException {
		PreparedStatement stm=con.prepareStatement("insert into placement values(?,?,?,?)");
		
		System.out.println("Enter the id:");
		stm.setInt(1, scan.nextInt());
		System.out.println("Enter the name:");
		stm.setString(2, scan.next());
		System.out.println("Enter the company name:");
		stm.setString(3, scan.next());
		System.out.println("Enter the sallary:");
		stm.setDouble(4, scan.nextDouble());
		
		System.out.println(stm.executeUpdate()+" rows inserted");
	}
	
	
	public static void updateData() throws SQLException {
		PreparedStatement stm=con.prepareStatement("update placement set company=? where id=?");
		System.out.println("Enter the company name:");
		stm.setString(1, scan.next());
		System.out.println("Enter the id:");
		stm.setInt(2, scan.nextInt());
		
		System.out.println(stm.executeUpdate() + " Rows updated");
		
		
	}
	public static void deleteData() throws SQLException {
		PreparedStatement stm=con.prepareStatement("delete from placement where id=?");
		System.out.println("Enter the id:");
		stm.setInt(1, scan.nextInt());
		
		System.out.println(stm.executeUpdate() + " Rows updated");
		
		
	}
	
	public static void fetchData() throws SQLException {
		PreparedStatement stm=con.prepareStatement("select * from placement");
		ResultSet rs=stm.executeQuery();
		int count=0;
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " +rs.getString(2) +" " + rs.getString(3)+" "+rs.getDouble(4));
			count++;
		}
		System.out.println(count+ "rows affected");
	}

	public static void main(String[] args) {
		try {
			
			fetchData();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
