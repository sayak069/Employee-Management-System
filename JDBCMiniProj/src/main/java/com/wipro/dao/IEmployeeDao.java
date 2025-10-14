package com.wipro.dao;

import com.wipro.bean.Employee;

public interface IEmployeeDao {
	String add(Employee e);
	Employee search(Integer eno);
	String update(Employee e);
	String delete(Integer eno);
}
