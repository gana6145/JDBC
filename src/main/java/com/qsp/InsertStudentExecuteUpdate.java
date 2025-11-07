package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentExecuteUpdate {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
//			Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root");
			Statement stm=con.createStatement();
			stm.executeUpdate("insert into student values(9,'nagesh',8975893966),(10,'ford',9876543210)");
			con.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

	}

}
