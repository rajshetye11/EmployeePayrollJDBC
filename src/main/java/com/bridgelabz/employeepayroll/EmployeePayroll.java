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
		                            rs.getString(4)+" "+
		                            rs.getString(5)
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
	public void getDatabyDate() throws SQLException {
		JDBCConn jdbccon = new JDBCConn();
		con = jdbccon.establishDbConnection();
		
		String query = "SELECT * FROM employee_payroll WHERE start BETWEEN CAST('2018-01-01' AS DATE) AND DATE(NOW())";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {			
			System.out.println(
					rs.getString(1)+" "+
					rs.getString(2)+" "+
					rs.getString(4));
		}
		
		
	}
	
	public void databaseFunctions(String func) throws SQLException{
		try {
			JDBCConn jdbccon = new JDBCConn();
			con = jdbccon.establishDbConnection();
			String sql=String.format("select gender,%s(salary) from employee_payroll where gender=\"M\" group by gender",func);
			Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {			
				System.out.println(
						rs.getString(1)+" "+
						rs.getString(2));
			}		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
