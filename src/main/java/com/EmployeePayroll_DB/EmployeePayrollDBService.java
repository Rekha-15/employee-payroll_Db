/********************************************************************************************
 * @Purpose JDBC Employee Payroll Service program to perform various operations in database. 
 * @author Rekha
 * @version 1.0
 * @since 24/06/2021
 ************************************************************************************************/
package com.EmployeePayroll_DB;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * steps to follow to connect Java application with database 
 * 1) Import java.sql
 * 2) Load and register the driver 
 * 3) Create connection 
 * 4) Create a statement
 * 5)Execute the query 
 * 6) Process the results 
 * 7) Close resources
 */

public class EmployeePayrollDBService {
	/**
	 * main method
	 * Printing welcome message
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
	
		System.out.println("Welcome to JDBC Employee Payroll Service program to perform various operations in database");
		
		{
		
		/**
		 * Connecting program to database
		 */
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String username = "root";
		String password = "root15";
		Connection connection;
		try {
			System.out.println("connecting to database");
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected Successfully!");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		listDrivers();
	}
	}

	/**
	 * list Drivers is a method 
	 * In this method listing Driver used
	 */

	private static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}
}