package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root");
			
			PreparedStatement str= con.prepareStatement("update student set name=? where id=?");
			str.setString(1,"Gana");
			str.setInt(2, 5);
			str.execute();
			System.out.println("data updated");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
