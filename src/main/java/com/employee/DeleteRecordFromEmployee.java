package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecordFromEmployee {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee","postgres","root");
			Statement str=con.createStatement();
			int n =str.executeUpdate("delete from emp where empid=1");
			System.out.println(n+" rows affected");
			ResultSet s=str.executeQuery("Select * from emp");
			while(s.next()) {
				System.out.println(s.getInt(1) +" " + s.getString(2) + " " +s.getInt(3));
			}
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static int getInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
