package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDriver {

	public static void main(String[] args)  {
		
			try {
				Class.forName("org.postgresql.Driver");
				System.out.println("Driver Loaded");
//				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
				Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root");
				System.out.println("connection created");
				Statement stm=con.createStatement();
				boolean b= stm.execute("insert into student values(1,'ganesh',9923906995)");
				System.out.println(b);
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
			}
			
		
		

	}

}
