package com.bridgelabz.employeepayroll;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

import org.junit.Test;

public class EmployeePayrollTest {
	@Test
    public void get_DbConnection() throws SQLException {
    	Connection dbConnection= new EmployeePayroll().establishDatabaseConnection();
    	System.out.println(dbConnection);
    	
	}
	
	 @Test
	 public void get_AllEmployee() throws SQLException {
	    Connection dbConnection= new EmployeePayroll().establishDatabaseConnection();
	    Statement st =  dbConnection.createStatement();
	    PreparedStatement ps= dbConnection.prepareStatement("select * from employee_payroll");
	    ResultSet resultset= ps.executeQuery();
	    while (resultset.next())
	    {
	        System.out.println(
	        		resultset.getString(1)+" "+
	                resultset.getString(2)+ " "+
	                resultset.getString(3)+" "+
	                resultset.getString(4)
	        );
	    }
	 }
	 
	 @Test
	 public void updateEmployee() throws SQLException {
	    Connection dbConnection= new EmployeePayroll().establishDatabaseConnection();
	    Statement st =  dbConnection.createStatement();
	    PreparedStatement ps= dbConnection.prepareStatement("update employee_payroll set salary=300000.00 where id = 2");
	    int resultset= ps.executeUpdate();
	   
	 }
}
