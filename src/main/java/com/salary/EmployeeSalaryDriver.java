package com.salary;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeSalaryDriver {
public static void main(String args[]) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee?user=postgres&password=root");
		CallableStatement cs=con.prepareCall("call insert_salary(?,?)");
		cs.setInt(1, 1);
		cs.setDouble(2, 24000);
		cs.execute();
		System.out.println("data inserted");
		con.close();
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
