package com.bridgelabz.employeepayroll;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

import org.junit.Test;

public class EmployeePayrollTest {
	
	public EmployeePayroll ep = new EmployeePayroll();
	
	@Test
    public void get_DbConnection() throws SQLException {
    	Connection dbConnection= new JDBCConn().establishDbConnection();
    	ep.getDatafromDatabase();
    	dbConnection.close(); 	
	}
	
	@Test
    public void updateEmployeePay() throws SQLException {
    	Connection dbConnection= new JDBCConn().establishDbConnection();
    	ep.updateEmployee("Terissa",300000.00);
    	dbConnection.close();
    }
	
}
