package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DeleteStudent {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp" , "postgres" ,"root");
			Statement str= con.createStatement();
			str.execute("delete from student where id=1");
			str.execute("insert into student values(1,'ganesh',9923906995)");
			str.execute("insert into student values(2,'Omkar',9923906995)");
			str.execute("insert into student values(3,'Om',9923906995)");
			str.execute("insert into student values(4,'Ankit',9923906995)");
			str.execute("insert into student values(5,'Anushka',9923906995)");
			System.out.println("data updated successfully");
			con.close();
			
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

	}

}
