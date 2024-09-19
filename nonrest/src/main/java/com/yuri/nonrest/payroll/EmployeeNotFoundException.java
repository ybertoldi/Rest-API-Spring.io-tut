package com.yuri.nonrest.payroll;

public class EmployeeNotFoundException extends RuntimeException{

	EmployeeNotFoundException(Long id){
		super("Could not find empoyee " + id);
	}
}
