package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDataFromEmployee {

	public static void main(String[] args) {
		try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee?user=postgres&password=root");
	    Statement str	=con.createStatement();
	    
	    ResultSet rs=str.executeQuery("select * from emp order by empid");
	    while(rs.next()) {
	    	System.out.println(rs.getInt("empid") +" " +rs.getString("name")+" " + rs.getInt("deptno"));
	    }
	    con.close();
		
	}   catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	}

}
