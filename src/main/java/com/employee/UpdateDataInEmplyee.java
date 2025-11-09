package com.employee;

import java.sql.*;

public class UpdateDataInEmplyee {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee?user=postgres&password=root");
		    Statement str =con.createStatement();
		    System.out.println("conection created");
		    
		    int n=str.executeUpdate("update  emp set name='ganesh' where empid=1 ");
		    System.out.println(n+" rows affected");
		    ResultSet rs=str.executeQuery("select * from emp order by empid");
		    while(rs.next()) {
		    System.out.println(rs.getInt("empid") +" " +rs.getString("name")+" " + rs.getInt("deptno"));
		    	}
		    con.close();
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
