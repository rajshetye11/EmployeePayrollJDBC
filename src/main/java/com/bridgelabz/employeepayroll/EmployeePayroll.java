package com.bridgelabz.employeepayroll;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class EmployeePayroll {
	Connection con;
	
	public void getDatafromDatabase() throws SQLException {
		try {
			JDBCConn jdbccon = new JDBCConn();
			con = jdbccon.establishDbConnection();
			String query = "select * from employee_payroll";
			Statement stmt =  con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				 System.out.println(
		                    rs.getString(1)+" "+
		                            rs.getString(2)+ " "+
		                            rs.getString(3)+" "+
		                            rs.getString(4)
		            );
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(String name, double salary) throws SQLException {
		try{
			JDBCConn jdbccon = new JDBCConn();
			con = jdbccon.establishDbConnection();
			
			String query = "update employee_payroll set salary=? where name=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDouble(1, salary);
			ps.setString(2, name);
			ps.executeUpdate();
			System.out.println("Done");			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
}
}
