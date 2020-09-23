package com.employee.details;

class PartTimeEmployee extends Employee {

	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Override
	boolean select() {
		return employeeDao.select("part_time_employee");
		
		
	}

	@Override
	boolean insert(EmployeeEntity empEntity) {
		return employeeDao.insert("part_time_employee", empEntity);
		
	}

	@Override
	boolean modify(EmployeeEntity empEntity) {
		 return employeeDao.modify("part_time_employee",empEntity);
		
	}

	@Override
	boolean delete(int empId) {
		return employeeDao.delete("part_time_employee", empId);
		
	}

	@Override
	boolean search(String empNameSearch) {
		return employeeDao.search("part_time_employee",empNameSearch);
		
	}

}
