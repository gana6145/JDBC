package com.qsp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RetrieveDataFromStudentTable {
	
	

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root");
			System.out.println("connection created");
			Statement stm=con.createStatement();
//			stm.execute("insert into student values (6,'Ajinkya',9422945645),(7,'Omnee',9876565656)");
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter yourr Sql Query Here:");
			ResultSet rs=stm.executeQuery(scan.nextLine());
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
//				System.out.println(rs.getString("name"));
//				System.out.println(rs.getLong("phone"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
