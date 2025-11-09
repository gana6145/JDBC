package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataInEmployee {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee?user=postgres&password=root");
		    Statement str	=con.createStatement();
		    str.executeUpdate("insert into emp values(1,'king',10),(4,'ford',20),(5,'miller',30)");
		    System.out.println("record inserted");
		    
		    ResultSet rs=str.executeQuery("select * from emp");
		    while(rs.next()) {
		    	System.out.println(rs.getInt("empid") +" " +rs.getString("name")+" " + rs.getInt("deptno"));
		    }
		    con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
