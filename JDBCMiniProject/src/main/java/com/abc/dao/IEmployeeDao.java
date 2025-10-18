package com.abc.dao;

import com.abc.bean.Employee;

public interface IEmployeeDao {
	String add(Employee e);
	Employee search(Integer eno);
	String update(Employee e);
	String delete(Integer eno);
}
