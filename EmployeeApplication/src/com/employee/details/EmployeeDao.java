package com.employee.details;

public interface EmployeeDao {

	boolean select(String tableName);

	boolean search(String tableName,String empNameSearch);

	boolean modify(String tableName, EmployeeEntity empEntity);

	boolean insert(String tableName, EmployeeEntity empEntity);

	boolean delete(String tableName, int empId);

}
