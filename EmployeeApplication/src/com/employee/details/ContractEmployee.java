package com.employee.details;

public class ContractEmployee extends Employee{

	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Override
	boolean select() {
		return employeeDao.select("contract_employee");
		
	}

	@Override
	boolean insert(EmployeeEntity empEntity) {
		return employeeDao.insert("contract_employee", empEntity);
		
	}

	@Override
	boolean modify(EmployeeEntity empEntity) {
		return employeeDao.modify("contract_employee",empEntity);
		
	}

	@Override
	boolean delete(int empId) {
		return employeeDao.delete("contract_employee", empId);
		
	}

	@Override
	boolean search(String empNameSearch) {
		return employeeDao.search("part_time_employee",empNameSearch);
		
	}

}
