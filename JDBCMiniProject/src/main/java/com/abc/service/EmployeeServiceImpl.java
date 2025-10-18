package com.abc.service;

import com.abc.bean.Employee;
import com.abc.dao.IEmployeeDao;
import com.abc.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public String addEmployee(Employee e) {
		IEmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.add(e);
	}

	@Override
	public Employee searchEmployee(Integer eno) {
		IEmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.search(eno);
	}

	@Override
	public String updateEmployee(Employee e) {
		IEmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.update(e);
	}

	@Override
	public String deleteEmployee(Integer eno) {
		IEmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.delete(eno);
	}

}
