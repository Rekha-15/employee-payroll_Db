package com.EmployeePayroll_DB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DatabaseService {
    public static void main(String[] args) {

        //declared jdbcUrl, username, password
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String username = "root";
        String password = "rekha15";
        Connection connection;

        try {
            //calling class for mysql driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw  new IllegalStateException("Cannot find database driver in the Classpath", e);
        }
        listDriver();
        try {
            System.out.println("Connecting to database: " +jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection is Successful! " +connection);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    //to check the list of drivers present
    private static void  listDriver() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = driverList.nextElement();
            System.out.println("  " +driverClass.getClass().getName());
        }
    }
}