/********************************************************************************************
 * @Purpose JDBC Employee Payroll Service program to perform various operations in database. 
 * Testing class
 * @author Rekha
 * @version 1.0
 * @since 24/06/2021
 ************************************************************************************************/
package com.EmployeePayroll_DB;

import org.junit.Assert;
import org.junit.Test;

import model.EmployeePayrollData;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static com.EmployeePayroll_DB.EmployeePayrollService.IOService.DB_IO;

public class EmployeePayrollServiceTest {

    /**
     * test case is created to check whether data is retrieved or not from database
     */
    @Test
    public void givenEmployeePayrollInDB_WhenDataRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(DB_IO);
        Assert.assertEquals(3, employeePayrollData.size());
    }

    /**
     * test case is created to check whether data is update or not in database
     */
    @Test
    public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDB() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(DB_IO);
        employeePayrollService.updateEmployeeSalary("Rekha", 600000.00);
        boolean result = employeePayrollService.checkEmployeePayrollSyncWithDB("Rekha");
        Assert.assertTrue(result);
    }

    /**
     * test case is created to check whether data is retrieved from database in a particular date range
     */
    @Test
    public void givenDateRange_WhenRetrievedData_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(DB_IO);
        LocalDate startDate = LocalDate.of(2018, 1, 28);
        LocalDate endDate = LocalDate.now();
        List<EmployeePayrollData> employeePayrollDataList = employeePayrollService.readEmployeePayrollDataForDateRange(DB_IO, startDate, endDate);
        Assert.assertEquals(3, employeePayrollDataList.size());
    }

    /**
     * test case is created to check average salary by gender
     */
    @Test
    public void givenPayrollData_WhenAverageSalaryRetrieveByGender_ShouldReturnValue() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(DB_IO);
        Map<String, Double> averageSalaryByGender = employeePayrollService.readAverageSalaryByGender(DB_IO);
        Assert.assertTrue(averageSalaryByGender.get("M").equals(500000.00) &&
                              averageSalaryByGender.get("F").equals(475000.00));
    }

    /**
     * test case is created to check sum salary by gender
     */
    @Test
    public void givenPayrollData_WhenSumSalaryRetrieveByGender_ShouldReturnValue() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(DB_IO);
        Map<String, Double> sumSalaryByGender = employeePayrollService.readSumSalaryByGender(DB_IO);
        Assert.assertTrue(sumSalaryByGender.get("M").equals(1500000.00) &&
                              sumSalaryByGender.get("F").equals(950000.00));
    }

    /**
     * test case is created to check minimum salary by gender
     */
    @Test
    public void givenPayrollData_WhenMinimumSalaryRetrieveByGender_ShouldReturnValue() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(DB_IO);
        Map<String, Double> minimumSalaryByGender = employeePayrollService.readMinimumSalaryByGender(DB_IO);
        Assert.assertTrue(minimumSalaryByGender.get("M").equals(400000.00) &&
                minimumSalaryByGender.get("F").equals(450000.00));
    }

    /**
     * test case is created to check maximum salary by gender
     */
    @Test
    public void givenPayrollData_WhenMaximumSalaryRetrieveByGender_ShouldReturnValue() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(DB_IO);
        Map<String, Double> maximumSalaryByGender = employeePayrollService.readMaximumSalaryByGender(DB_IO);
        Assert.assertTrue(maximumSalaryByGender.get("M").equals(600000.00) &&
                maximumSalaryByGender.get("F").equals(500000.00));
    }

    /**
     * test case is created to check count name by gender
     */
    @Test
    public void givenPayrollData_WhenCountNameRetrieveByGender_ShouldReturnValue() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(DB_IO);
        Map<String, Integer> countNameByGender = employeePayrollService.readCountNameByGender(DB_IO);
        Assert.assertTrue(countNameByGender.get("M").equals(3) &&
                countNameByGender.get("F").equals(2));
    }

    /**
     * tested whether new employee added or not
     */
    @Test
    public void givenNewEmployee_whenAdded_ShouldSyncWithDB() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readEmployeePayrollData(DB_IO);
        employeePayrollService.addEmployeeToPayroll("nammu", "M", 400000.00, LocalDate.now());
        boolean result = employeePayrollService.checkEmployeePayrollSyncWithDB("nammu");
        Assert.assertTrue(result);
    }
}