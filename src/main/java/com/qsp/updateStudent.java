package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class updateStudent {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
//			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp","postgres","root");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root");
			Statement str=con.createStatement();
			boolean b=str.execute("update student set name='omkar' where id=1");
			System.out.println(b);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
