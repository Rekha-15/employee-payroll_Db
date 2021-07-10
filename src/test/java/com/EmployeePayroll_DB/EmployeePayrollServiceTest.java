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
import java.util.List;

/**
 * EmployeePayrollServiceTest is a testing 
 * Testing for both true and false scenario
 * 
 * @author rekha
 */

public class EmployeePayrollServiceTest {
	@Test
	public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
		EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
		List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.readData();
		Assert.assertEquals(4, employeePayrollDataList.size());
	}

	/**
	 * In this test case given a EmployeePayrollInDB 
	 * When it Retrieved it Should not Match EmployeeCount.
	 */
	@Test
	public void givenEmployeePayrollInDB_WhenRetrieved_ShouldnotMatchEmployeeCount() {
		EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
		List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.readData();
		Assert.assertNotSame(5, employeePayrollDataList.size());
	}

	/**
	 * In this test case given New Employee Salary Should Update With Database.
	 */
	@Test
	public void givenNewEmployeeSalaryShouldUpdateWithDatabase() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<EmployeePayrollData> employeePayrollDataList = employeePayrollService
				.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
		employeePayrollService.updateEmployeebasic_pay("Terisa", 3000000.00);
		boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terisa");
		Assert.assertTrue(result);
	}
	
	@Test
    public void givenDataRangeWhenRetrievedShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollDataList = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.retrieveEmployyesForGivenDataRange("2018-01-01", "2019-01-03");
        Assert.assertEquals(1, employeePayrollData.size());
    }
}