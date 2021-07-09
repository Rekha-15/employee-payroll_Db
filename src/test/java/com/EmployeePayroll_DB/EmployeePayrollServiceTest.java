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
 * @author rekha
 *
 */
public class EmployeePayrollServiceTest {
	@Test
	public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
		EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
		List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.readData();
		Assert.assertEquals(3, employeePayrollDataList.size());
	}
	
	@Test
	public void givenEmployeePayrollInDB_WhenRetrieved_ShouldnotMatchEmployeeCount() {
		EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();
		List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.readData();
		Assert.assertNotSame(4, employeePayrollDataList.size());
	}
}