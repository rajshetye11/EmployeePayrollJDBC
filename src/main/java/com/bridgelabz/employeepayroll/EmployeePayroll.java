package com.bridgelabz.employeepayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeePayroll {
	private String url = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	private String username = "root";
    private String password = "root";
    Connection con;

    public Connection establishDatabaseConnection() throws SQLException {	       
    	try {
	          Class.forName("com.mysql.jdbc.Driver");
	          con = DriverManager.getConnection(url, username, password);
	          System.out.println("Connection Successful "+con);
    	}
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return con;
    }
}