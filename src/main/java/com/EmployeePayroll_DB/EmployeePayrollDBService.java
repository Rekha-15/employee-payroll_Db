/********************************************************************************************
 * @Purpose JDBC Employee Payroll Service program to perform various operations in database. 
 * @author Rekha
 * @version 1.0
 * @since 24/06/2021
 ************************************************************************************************/
package com.EmployeePayroll_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import model.EmployeePayrollData;

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

public class  EmployeePayrollDBService {

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String username = "root";
        String password = "root15";
        System.out.println("connecting to database");
        Connection connection = DriverManager.getConnection(jdbcURL,username,password);
        System.out.println("Connected Successfully!");
        return connection;
    }

    /**
     * readsata method we will select table query.
     * @return employeePayrollList
     */
    
    public ArrayList<EmployeePayrollData> readData() {
        String sql = "SELECT * FROM employee_payroll";
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        try {
            Connection connection = this.getConnection();
            Statement  statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                LocalDate startDate = resultSet.getDate("start").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }
        /*public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        listDrivers();
    }
    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }*/
}