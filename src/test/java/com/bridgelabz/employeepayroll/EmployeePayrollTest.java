package com.bridgelabz.employeepayroll;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class EmployeePayrollTest {
	@Test
    public void get_DbConnection() throws SQLException {
    	Connection dbConnection= new EmployeePayroll().establishDatabaseConnection();
    	System.out.println(dbConnection);
    	
	}
}
