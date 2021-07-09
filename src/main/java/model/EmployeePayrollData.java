/********************************************************************************************
 * @Purpose JDBC Employee Payroll Service program to perform various operations in database. 
 * @author Rekha
 * @version 1.0
 * @since 24/06/2021
 ************************************************************************************************/

package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * EmployeePayrollData is class of public type ,Pojo class
 * 
 * @author rekha
 *
 */
public class EmployeePayrollData {
	public int id;
	public String name;
	public double basic_pay;
	public LocalDate startDate;

	/**
	 * Parameterized constructor is created.
	 * 
	 * @param id
	 * @param name
	 * @param basic_pay
	 * @param startDate
	 */

	public EmployeePayrollData(int id, String name, double basic_pay, LocalDate startDate) {
		this.id = id;
		this.name = name;
		this.basic_pay = basic_pay;
		this.startDate = startDate;
	}

	/**
	 * This method use to print all the value.
	 */

	@Override
	public String toString() {
		return "EmployeePayrollData{" + "id=" + id + ", name='" + name + '\'' + ", basic_pay=" + basic_pay + ", startDate="
				+ startDate + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EmployeePayrollData that = (EmployeePayrollData) o;
		return id == that.id && Double.compare(that.basic_pay, basic_pay) == 0 && Objects.equals(name, that.name);
	}
}