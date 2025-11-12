package com.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertDataUsingCallableStatement {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
			CallableStatement str= con.prepareCall("call insert_student(?,?,?)");
			str.setInt(1,23);
			str.setString(2, "Tejas");
			str.setLong(3, 987654321);
			str.execute();
			System.out.println("data inserted");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
