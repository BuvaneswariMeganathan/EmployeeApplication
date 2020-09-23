package com.employee.details;

import java.util.Scanner;

public class EmployeeController {
	public static void main(String args[]){  
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter which type of details you want to access?\n(Please enter corresponding number) \n 1.Permanent Employee \n 2.Part Time Employeee \n 3.Contract Employee \n 4.Exit \n ");
		int empType=1;
		do {
		while(!scanner.hasNextInt())
		{
			scanner.next();
			System.out.println("Please enter valid input");
		}
		
		empType =scanner.nextInt();
		}while(empType<0);
		while(empType!=4) {
		System.out.println("Enter which type of operation you want to do?\n(Please enter corresponding number) \n 1.Select \n 2.Insert \n 3.Modify \n 4.Delete \n 5.Search \n 6.Exit ");
		int operation =scanner.nextInt();

		Employee permanent = new PermanentEmployee();
		Employee partTime = new PartTimeEmployee();
		Employee contract = new ContractEmployee();
		
		
		switch(operation)
		{
		case 1:
			boolean isFetch=(empType==1)?(permanent.select()):((empType==2)?partTime.select():((empType==3)?contract.select():false));
			if(isFetch)
			System.out.println("Employee records fetched successfully!\n");
			else
			System.out.println("Invalid Operation or No records\n");	
			break;
		case 2:
			EmployeeEntity empEntity = new EmployeeEntity();
			System.out.println("Enter employee Id which you want to insert");
			int empIdInsert = scanner.nextInt();
			empEntity.setEmp_id(empIdInsert);
			System.out.println("Enter employee name which you want to insert");
			String empNameInsert = scanner.next();
			empEntity.setEmp_name(empNameInsert);
			System.out.println("Enter employee email which you want to insert");
			String empEmailInsert = scanner.next();
			empEntity.setEmp_email(empEmailInsert);
			System.out.println("Enter employee salary which you want to insert");
			int empSalaryInsert = scanner.nextInt();
			empEntity.setEmp_salary(empSalaryInsert);
			boolean isInsert=(empType==1)?(permanent.insert(empEntity)):((empType==2)?partTime.insert(empEntity):((empType==3)?contract.insert(empEntity):false));
			if(isInsert)
				System.out.println("A new employee was inserted successfully!\n");
			else
				System.out.println("Invalid Operation or Error Occured\n");
			break;
		case 3:
			EmployeeEntity empEntityUpdate = new EmployeeEntity();
			System.out.println("Enter employee name which you want to update");
			String empNameUpdate = scanner.next();
			empEntityUpdate.setEmp_name(empNameUpdate);
			System.out.println("Enter updated employee email");
			String empEmailUpdate = scanner.next();
			empEntityUpdate.setEmp_email(empEmailUpdate);
			System.out.println("Enter updated employee salary");
			int empSalaryUpdate = scanner.nextInt();
			empEntityUpdate.setEmp_salary(empSalaryUpdate);
			boolean isUpdate=(empType==1)?(permanent.modify(empEntityUpdate)):((empType==2)?partTime.modify(empEntityUpdate):((empType==3)?contract.modify(empEntityUpdate):false));
			if(isUpdate)
				 System.out.println("\nRecord updated successfully!!\n");
			else
				System.out.println("Invalid Operation or Error Occured\n");
			break;
		case 4:
			System.out.println("Enter employee Id which you want to delete");
			int empId = scanner.nextInt();
			boolean isSuccess=(empType==1)?(permanent.delete(empId)):((empType==2)?partTime.delete(empId):((empType==3)?contract.delete(empId):false));
			if(isSuccess)
			System.out.println("A employee was deleted successfully!\n");
			else
			System.out.println("Invalid Operation or No matched records\n");	
			break;
		case 5:
			System.out.println("Enter employee name which you want to search");
			String empNameSearch = scanner.next();
			boolean isSearch=(empType==1)?(permanent.search(empNameSearch)):((empType==2)?partTime.search(empNameSearch):((empType==3)?contract.search(empNameSearch):false));
			if(isSearch)
			System.out.println("Employee record found!\n");
			else
			System.out.println("Invalid Operation or No matched records\n");	
			break;
		case 6:
			System.out.println("Program Ends\n");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Operation");
			break;
		}}

}}
