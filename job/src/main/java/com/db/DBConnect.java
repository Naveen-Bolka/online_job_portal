package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static Connection con;
	
	public static Connection getCon() {
	
		try {
			if(con==null) {
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			}
		}catch(ClassNotFoundException e) {
			System.out.println("No Driver class is found");
		}catch(SQLException s){
			System.out.println("Not connetced");
		}
		
		return con;
	}
	
}
