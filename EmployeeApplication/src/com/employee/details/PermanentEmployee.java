package com.employee.details;

public class PermanentEmployee extends Employee {

	EmployeeDao employeeDao = new EmployeeDaoImpl();
	@Override
	boolean select() {
		return employeeDao.select("permanent_employee");
		
	}

	@Override
	boolean insert(EmployeeEntity empEntity) {
		return employeeDao.insert("permanent_employee", empEntity);
		
	}

	@Override
	boolean modify(EmployeeEntity empEntity) {
		return employeeDao.modify("permanent_employee",empEntity);
		
	}

	@Override
	boolean delete(int empId) {
		return employeeDao.delete("permanent_employee", empId);
		
	}

	@Override
	boolean search(String empNameSearch) {
		return employeeDao.search("permanent_employee", empNameSearch);
		
	}

}
