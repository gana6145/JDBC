package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root");
			PreparedStatement str= con.prepareStatement("insert into student values(?,?,? )");
			str.setInt(1, 10);
			str.setString(2, "Nagesh");
			str.setLong(3, 448765431);
			str.execute();
			System.out.println("data inserted ");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
