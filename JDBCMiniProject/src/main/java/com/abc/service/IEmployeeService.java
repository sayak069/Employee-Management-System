package com.abc.service;

import com.abc.bean.Employee;

public interface IEmployeeService {
	String addEmployee(Employee e);
	Employee searchEmployee(Integer eno);
	String updateEmployee(Employee e);
	String deleteEmployee(Integer eno);
}
