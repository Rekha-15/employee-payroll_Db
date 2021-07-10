/********************************************************************************************
 * @Purpose JDBC Employee Payroll Service program to perform various operations in database. 
 * @author Rekha
 * @version 1.0
 * @since 24/06/2021
 ************************************************************************************************/
package com.EmployeePayroll_DB;

import java.util.List;
import model.EmployeePayrollData;

/**
 * EmployeePayrollService sevice class
 * writing enum method 
 */
public class EmployeePayrollService {

	public enum IOService {
		DB_IO
	}

	private List<EmployeePayrollData> employeePayrollDataList;
	private EmployeePayrollDBService employeePayrollDBService;

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollDataList) {
		this();
		this.employeePayrollDataList = employeePayrollDataList;
	}

	EmployeePayrollService() {
		employeePayrollDBService = EmployeePayrollDBService.getInstant();
	}

	/**
	 * reading data into list 
	 * @param ioService
	 * @return employeePayrollDataList
	 */
	public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService) {
		this.employeePayrollDataList = employeePayrollDBService.readData();
		return employeePayrollDataList;
	}

	public boolean checkEmployeePayrollInSyncWithDB(String name) {
		List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.getEmployeePayrollData(name);
		return employeePayrollDataList.get(0).equals(getEmployeePayrollData(name));
	}

	/**
	 * This method is written to retrieve salary by name
	 */
	private EmployeePayrollData getEmployeePayrollData(String name) {
		return this.employeePayrollDataList.stream()
				.filter(employeePayrollData -> employeePayrollData.name.equals(name)).findFirst().orElse(null);
	}

	/**
	 * Function to update the salary by name
	 */
	public void updateEmployeebasic_pay(String name, double basic_pay) {
		int result = employeePayrollDBService.updateEmployeeData(name, basic_pay);
		if (result == 0)
			return;
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollData(name);
		if (employeePayrollData != null)
			employeePayrollData.basic_pay = basic_pay;
	}
	
	public List<EmployeePayrollData> retrieveEmployyesForGivenDataRange(String startDate, String endDate) {
        List<EmployeePayrollData> employeePayrollDataList = employeePayrollDBService.retrieveEmployeePayrollDataRange(startDate, endDate);
        return employeePayrollDataList;
    }
}
