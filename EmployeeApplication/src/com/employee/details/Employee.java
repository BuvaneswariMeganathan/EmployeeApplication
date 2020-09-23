package com.employee.details;

abstract class Employee {
	
	abstract boolean select();

	abstract boolean insert(EmployeeEntity empEntity);

	abstract boolean modify(EmployeeEntity empEntity);

	abstract boolean delete(int empId);

	abstract boolean search(String empNameSearch);

}
