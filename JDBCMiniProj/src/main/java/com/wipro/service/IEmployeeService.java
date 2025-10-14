package com.wipro.service;

import com.wipro.bean.Employee;

public interface IEmployeeService {
	String addEmployee(Employee e);
	Employee searchEmployee(Integer eno);
	String updateEmployee(Employee e);
	String deleteEmployee(Integer eno);
}
